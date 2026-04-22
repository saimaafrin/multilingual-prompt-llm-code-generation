import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketAppender extends AppenderSkeleton {
    
    private List<Socket> connectedClients;
    private List<PrintWriter> writers;
    
    public SocketAppender() {
        connectedClients = new ArrayList<>();
        writers = new ArrayList<>();
    }

    @Override
    protected void append(LoggingEvent event) {
        if (event == null) return;
        
        String message = this.layout.format(event);
        
        // Remove disconnected clients
        List<Integer> disconnectedIndexes = new ArrayList<>();
        
        // Send message to all connected clients
        for (int i = 0; i < writers.size(); i++) {
            try {
                PrintWriter writer = writers.get(i);
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                disconnectedIndexes.add(i);
            }
        }
        
        // Clean up disconnected clients
        for (int i = disconnectedIndexes.size() - 1; i >= 0; i--) {
            int index = disconnectedIndexes.get(i);
            try {
                connectedClients.get(index).close();
            } catch (IOException e) {
                // Ignore close errors
            }
            connectedClients.remove(index);
            writers.remove(index);
        }
    }

    public void addClient(Socket client) throws IOException {
        connectedClients.add(client);
        writers.add(new PrintWriter(client.getOutputStream()));
    }

    @Override
    public void close() {
        for (Socket client : connectedClients) {
            try {
                client.close();
            } catch (IOException e) {
                // Ignore close errors
            }
        }
        connectedClients.clear();
        writers.clear();
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
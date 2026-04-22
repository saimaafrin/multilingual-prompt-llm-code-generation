import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketAppender extends AppenderSkeleton {
    private List<Socket> connectedClients;
    private List<PrintWriter> clientWriters;

    public SocketAppender() {
        connectedClients = new ArrayList<>();
        clientWriters = new ArrayList<>();
    }

    @Override
    protected void append(LoggingEvent event) {
        String message = layout.format(event);
        
        // Remove any disconnected clients
        List<Integer> disconnectedIndexes = new ArrayList<>();
        
        // Write message to each connected client
        for (int i = 0; i < clientWriters.size(); i++) {
            PrintWriter writer = clientWriters.get(i);
            try {
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                // Client likely disconnected
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
            clientWriters.remove(index);
        }
    }

    public void addClient(Socket client) throws IOException {
        connectedClients.add(client);
        clientWriters.add(new PrintWriter(client.getOutputStream(), true));
    }

    @Override
    public void close() {
        for (Socket socket : connectedClients) {
            try {
                socket.close();
            } catch (IOException e) {
                // Ignore close errors
            }
        }
        connectedClients.clear();
        clientWriters.clear();
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
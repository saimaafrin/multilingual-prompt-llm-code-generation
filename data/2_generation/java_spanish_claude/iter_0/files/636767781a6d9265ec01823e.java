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
        
        // Iterate through all connected clients and send the message
        for (int i = clientWriters.size() - 1; i >= 0; i--) {
            try {
                PrintWriter writer = clientWriters.get(i);
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                // If there's an error writing to client, remove them from the list
                removeClient(i);
            }
        }
    }

    public void addClient(Socket client) throws IOException {
        connectedClients.add(client);
        clientWriters.add(new PrintWriter(client.getOutputStream(), true));
    }

    private void removeClient(int index) {
        try {
            connectedClients.get(index).close();
        } catch (IOException e) {
            // Ignore close errors
        }
        connectedClients.remove(index);
        clientWriters.remove(index);
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
        clientWriters.clear();
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
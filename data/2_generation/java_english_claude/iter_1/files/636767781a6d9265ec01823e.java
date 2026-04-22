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
        for (int i = 0; i < connectedClients.size(); i++) {
            Socket client = connectedClients.get(i);
            if (client.isClosed() || !client.isConnected()) {
                disconnectedIndexes.add(i);
            }
        }
        
        // Remove from end to avoid index shifting
        for (int i = disconnectedIndexes.size() - 1; i >= 0; i--) {
            int index = disconnectedIndexes.get(i);
            connectedClients.remove(index);
            clientWriters.remove(index);
        }

        // Write message to all connected clients
        for (PrintWriter writer : clientWriters) {
            try {
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                // Handle failed write
                errorHandler.error("Failed to write to client", e, 
                    ErrorCode.WRITE_FAILURE);
            }
        }
    }

    public void addClient(Socket client) throws IOException {
        connectedClients.add(client);
        clientWriters.add(new PrintWriter(client.getOutputStream(), true));
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
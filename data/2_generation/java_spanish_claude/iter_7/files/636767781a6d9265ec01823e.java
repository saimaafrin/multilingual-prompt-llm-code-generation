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
    
    public SocketAppender() {
        connectedClients = new ArrayList<>();
    }
    
    public void addClient(Socket clientSocket) {
        connectedClients.add(clientSocket);
    }
    
    public void removeClient(Socket clientSocket) {
        connectedClients.remove(clientSocket);
    }

    @Override
    protected void append(LoggingEvent event) {
        if (layout == null) {
            return;
        }

        String message = layout.format(event);
        
        List<Socket> disconnectedClients = new ArrayList<>();
        
        for (Socket client : connectedClients) {
            try {
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                writer.println(message);
            } catch (IOException e) {
                // If we can't write to the socket, mark it for removal
                disconnectedClients.add(client);
            }
        }
        
        // Remove any disconnected clients
        connectedClients.removeAll(disconnectedClients);
    }

    @Override
    public void close() {
        for (Socket client : connectedClients) {
            try {
                client.close();
            } catch (IOException e) {
                // Ignore exceptions during cleanup
            }
        }
        connectedClients.clear();
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
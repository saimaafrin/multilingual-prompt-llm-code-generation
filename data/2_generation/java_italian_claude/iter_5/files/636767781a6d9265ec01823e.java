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
    
    public void addClient(Socket client) {
        connectedClients.add(client);
    }
    
    public void removeClient(Socket client) {
        connectedClients.remove(client);
    }
    
    @Override
    protected void append(LoggingEvent event) {
        String message = this.layout.format(event);
        
        List<Socket> disconnectedClients = new ArrayList<>();
        
        for(Socket client : connectedClients) {
            try {
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                writer.println(message);
            } catch(IOException e) {
                // If we can't write to the socket, mark it for removal
                disconnectedClients.add(client);
            }
        }
        
        // Remove any disconnected clients
        for(Socket client : disconnectedClients) {
            removeClient(client);
            try {
                client.close();
            } catch(IOException e) {
                // Ignore close errors
            }
        }
    }
    
    @Override
    public void close() {
        for(Socket client : connectedClients) {
            try {
                client.close();
            } catch(IOException e) {
                // Ignore close errors
            }
        }
        connectedClients.clear();
    }
    
    @Override
    public boolean requiresLayout() {
        return true;
    }
}
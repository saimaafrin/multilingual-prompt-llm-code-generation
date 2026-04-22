import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.log4j.spi.LoggingEvent;

public class SocketAppender {
    private List<Socket> clients = new CopyOnWriteArrayList<>();
    
    public void handleLogEvent(LoggingEvent event) {
        String message = event.getRenderedMessage();
        
        // Iterate through connected clients and write message
        for (Socket client : clients) {
            try {
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println(message);
            } catch (IOException e) {
                // Remove client if we can't write to it
                clients.remove(client);
            }
        }
    }
    
    // Helper method to add new client connections
    public void addClient(Socket client) {
        clients.add(client);
    }
    
    // Helper method to remove client connections
    public void removeClient(Socket client) {
        clients.remove(client);
    }
}
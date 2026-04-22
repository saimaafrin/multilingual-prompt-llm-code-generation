import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;

public class SocketAppender extends AbstractAppender {
    private List<Socket> clients = new CopyOnWriteArrayList<>();
    
    public void append(LogEvent event) {
        String message = event.getMessage().getFormattedMessage();
        
        // Write message to each connected client
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
    
    public void addClient(Socket client) {
        clients.add(client);
    }
    
    public void removeClient(Socket client) {
        clients.remove(client);
    }
}
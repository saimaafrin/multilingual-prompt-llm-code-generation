import org.apache.log4j.spi.LoggingEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class LogAppender {
    private List<Socket> clients = new ArrayList<>();

    /**
     * Handles a log event. For this appender, that means writing the message to each connected client.
     */
    protected void append(LoggingEvent event) {
        String message = event.getMessage().toString();
        for (Socket client : clients) {
            try {
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println(message);
            } catch (IOException e) {
                // Handle the exception, e.g., remove the client from the list
                clients.remove(client);
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds a client to the list of connected clients.
     */
    public void addClient(Socket client) {
        clients.add(client);
    }

    /**
     * Removes a client from the list of connected clients.
     */
    public void removeClient(Socket client) {
        clients.remove(client);
    }
}
import org.apache.log4j.spi.LoggingEvent;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class LogAppender {
    private List<PrintWriter> clients = new ArrayList<>();

    /**
     * Handles a log event. For this appender, that means writing the message to each connected client.
     */
    protected void append(LoggingEvent event) {
        String message = event.getRenderedMessage();
        synchronized (clients) {
            for (PrintWriter client : clients) {
                client.println(message);
                client.flush();
            }
        }
    }

    /**
     * Adds a new client to the list of connected clients.
     * @param clientSocket The socket of the connected client.
     */
    public void addClient(Socket clientSocket) {
        try {
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            synchronized (clients) {
                clients.add(writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes a client from the list of connected clients.
     * @param clientSocket The socket of the client to remove.
     */
    public void removeClient(Socket clientSocket) {
        try {
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            synchronized (clients) {
                clients.remove(writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
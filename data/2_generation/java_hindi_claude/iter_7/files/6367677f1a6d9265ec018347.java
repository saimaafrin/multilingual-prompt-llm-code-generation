import java.io.PrintWriter;
import java.util.List;

public class ChatServer {
    private List<PrintWriter> clientWriters;

    /**
     * sends a message to each of the clients in telnet-friendly output.
     */
    public void broadcast(String message) {
        for (PrintWriter writer : clientWriters) {
            try {
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                // Remove failed client
                clientWriters.remove(writer);
            }
        }
    }
}
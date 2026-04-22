import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private List<PrintWriter> clientWriters;

    public ChatServer() {
        clientWriters = new ArrayList<>();
    }

    /**
     * sends a message to each of the clients in telnet-friendly output.
     */
    public synchronized void send(final String message) {
        for (PrintWriter writer : clientWriters) {
            try {
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                // Remove failed client writer
                clientWriters.remove(writer);
            }
        }
    }

    // Method to add new client writer
    public synchronized void addClient(PrintWriter writer) {
        clientWriters.add(writer);
    }

    // Method to remove client writer
    public synchronized void removeClient(PrintWriter writer) {
        clientWriters.remove(writer);
    }
}
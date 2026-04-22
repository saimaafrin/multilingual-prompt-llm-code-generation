import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<Socket> clients = new ArrayList<>();

    public synchronized void addClient(Socket client) {
        clients.add(client);
    }

    public synchronized void removeClient(Socket client) {
        clients.remove(client);
    }

    /**
     * Sends a message to each of the clients in telnet-friendly output.
     */
    public synchronized void send(final String message) {
        for (Socket client : clients) {
            try {
                OutputStream outputStream = client.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println(message);
            } catch (Exception e) {
                // Handle exception, e.g., client disconnected
                removeClient(client);
            }
        }
    }
}
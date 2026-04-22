import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private final List<PrintWriter> clients = new ArrayList<>();

    /** 
     * sends a message to each of the clients in telnet-friendly output. 
     */
    public synchronized void send(final String message) {
        for (PrintWriter client : clients) {
            client.println(message);
            client.flush();
        }
    }

    public synchronized void addClient(PrintWriter client) {
        clients.add(client);
    }

    public synchronized void removeClient(PrintWriter client) {
        clients.remove(client);
    }
}
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private final List<Socket> clients = new ArrayList<>();

    public synchronized void send(final String message) {
        for (Socket client : clients) {
            try {
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void addClient(Socket client) {
        clients.add(client);
    }

    public synchronized void removeClient(Socket client) {
        clients.remove(client);
    }
}
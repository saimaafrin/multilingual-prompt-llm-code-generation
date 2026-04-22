import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private final List<Socket> clients = new ArrayList<>();

    /** 
     * Envía un mensaje a cada uno de los clientes en un formato compatible con telnet. 
     */
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

    public void addClient(Socket client) {
        synchronized (clients) {
            clients.add(client);
        }
    }

    public void removeClient(Socket client) {
        synchronized (clients) {
            clients.remove(client);
        }
    }
}
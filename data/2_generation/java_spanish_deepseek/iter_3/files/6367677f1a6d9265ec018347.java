import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<Socket> clients = new ArrayList<>();

    /**
     * Envía un mensaje a cada uno de los clientes en un formato compatible con telnet.
     */
    public synchronized void send(final String message) {
        for (Socket client : clients) {
            try {
                OutputStream outputStream = client.getOutputStream();
                outputStream.write(message.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                // Handle the exception, e.g., remove the client from the list
                clients.remove(client);
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds a new client to the list of connected clients.
     */
    public synchronized void addClient(Socket client) {
        clients.add(client);
    }

    /**
     * Removes a client from the list of connected clients.
     */
    public synchronized void removeClient(Socket client) {
        clients.remove(client);
    }
}
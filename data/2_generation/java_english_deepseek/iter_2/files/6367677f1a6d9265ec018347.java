import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<PrintWriter> clients = new ArrayList<>();

    /**
     * Sends a message to each of the clients in telnet-friendly output.
     * @param message The message to be sent to all connected clients.
     */
    public synchronized void send(final String message) {
        for (PrintWriter client : clients) {
            client.println(message);
            client.flush();
        }
    }

    /**
     * Adds a new client to the list of connected clients.
     * @param clientSocket The socket of the connected client.
     */
    public synchronized void addClient(Socket clientSocket) {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            clients.add(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes a client from the list of connected clients.
     * @param clientSocket The socket of the disconnected client.
     */
    public synchronized void removeClient(Socket clientSocket) {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            clients.remove(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
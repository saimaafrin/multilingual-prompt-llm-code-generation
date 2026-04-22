import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<PrintWriter> clients = new ArrayList<>();

    /**
     * Sends a message to each of the clients in telnet-friendly output.
     * 
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
     * 
     * @param socket The socket of the connected client.
     */
    public synchronized void addClient(Socket socket) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            clients.add(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes a client from the list of connected clients.
     * 
     * @param socket The socket of the disconnected client.
     */
    public synchronized void removeClient(Socket socket) {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            clients.remove(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
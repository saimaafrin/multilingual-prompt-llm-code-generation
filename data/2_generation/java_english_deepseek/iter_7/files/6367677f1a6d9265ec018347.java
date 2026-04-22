import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<PrintWriter> clients = new ArrayList<>();

    /**
     * Sends a message to each of the clients in telnet-friendly output.
     * 
     * @param message The message to send to all connected clients.
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes a client from the list of connected clients.
     * 
     * @param writer The PrintWriter associated with the client to be removed.
     */
    public synchronized void removeClient(PrintWriter writer) {
        clients.remove(writer);
    }
}
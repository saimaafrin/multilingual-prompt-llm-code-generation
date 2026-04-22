import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<Socket> clients = new ArrayList<>();

    /**
     * Sends a message to each of the clients in telnet-friendly output.
     * 
     * @param message The message to send to all connected clients.
     */
    public synchronized void send(final String message) {
        for (Socket client : clients) {
            try {
                OutputStream outputStream = client.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println(message);
            } catch (Exception e) {
                // Handle any exceptions, such as client disconnection
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds a client to the list of connected clients.
     * 
     * @param client The client socket to add.
     */
    public synchronized void addClient(Socket client) {
        clients.add(client);
    }

    /**
     * Removes a client from the list of connected clients.
     * 
     * @param client The client socket to remove.
     */
    public synchronized void removeClient(Socket client) {
        clients.remove(client);
    }
}
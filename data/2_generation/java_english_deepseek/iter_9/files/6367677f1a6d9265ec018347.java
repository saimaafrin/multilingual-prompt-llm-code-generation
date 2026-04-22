import java.io.IOException;
import java.io.OutputStream;
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
                outputStream.write(message.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                // Handle the exception, e.g., remove the client from the list
                clients.remove(client);
                System.err.println("Error sending message to client: " + e.getMessage());
            }
        }
    }

    /**
     * Adds a new client to the list of connected clients.
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
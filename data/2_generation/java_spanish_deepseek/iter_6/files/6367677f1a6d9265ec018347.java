import java.io.IOException;
import java.io.OutputStream;
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
     * Envía un mensaje a cada uno de los clientes en un formato compatible con telnet.
     */
    public synchronized void send(final String message) {
        for (Socket client : clients) {
            try {
                OutputStream outputStream = client.getOutputStream();
                outputStream.write(message.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                // Handle the exception, e.g., remove the client if the connection is lost
                removeClient(client);
                e.printStackTrace();
            }
        }
    }
}
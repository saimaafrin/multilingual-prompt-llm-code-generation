import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<Socket> clients = new ArrayList<>();

    /**
     * Envía un mensaje a cada uno de los clientes en un formato compatible con telnet.
     * @param message El mensaje a enviar.
     */
    public synchronized void send(final String message) {
        for (Socket client : clients) {
            try {
                OutputStream outputStream = client.getOutputStream();
                outputStream.write(message.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                // Manejar la excepción si no se puede enviar el mensaje al cliente
                e.printStackTrace();
            }
        }
    }

    /**
     * Agrega un nuevo cliente a la lista de clientes conectados.
     * @param client El socket del cliente.
     */
    public synchronized void addClient(Socket client) {
        clients.add(client);
    }

    /**
     * Elimina un cliente de la lista de clientes conectados.
     * @param client El socket del cliente.
     */
    public synchronized void removeClient(Socket client) {
        clients.remove(client);
    }
}
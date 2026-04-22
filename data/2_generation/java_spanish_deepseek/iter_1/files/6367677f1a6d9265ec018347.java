import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<Socket> clients = new ArrayList<>();

    /**
     * Envía un mensaje a cada uno de los clientes en un formato compatible con telnet.
     * @param message El mensaje a enviar a los clientes.
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
     * Agrega un nuevo cliente a la lista de clientes conectados.
     * @param client El socket del cliente a agregar.
     */
    public synchronized void addClient(Socket client) {
        clients.add(client);
    }

    /**
     * Elimina un cliente de la lista de clientes conectados.
     * @param client El socket del cliente a eliminar.
     */
    public synchronized void removeClient(Socket client) {
        clients.remove(client);
    }
}
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<Socket> clients = new ArrayList<>();

    /**
     * Invia un messaggio a ciascuno dei client in un formato compatibile con telnet.
     */
    public synchronized void send(final String message) {
        for (Socket client : clients) {
            try {
                OutputStream outputStream = client.getOutputStream();
                outputStream.write(message.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                // Gestione dell'errore, ad esempio rimuovendo il client dalla lista
                clients.remove(client);
                e.printStackTrace();
            }
        }
    }

    /**
     * Aggiunge un client alla lista dei client connessi.
     */
    public synchronized void addClient(Socket client) {
        clients.add(client);
    }

    /**
     * Rimuove un client dalla lista dei client connessi.
     */
    public synchronized void removeClient(Socket client) {
        clients.remove(client);
    }
}
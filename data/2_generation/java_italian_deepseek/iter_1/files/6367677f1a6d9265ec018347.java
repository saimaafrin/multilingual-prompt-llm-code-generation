import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<Socket> clients = new ArrayList<>();

    /**
     * Invia un messaggio a ciascuno dei client in un formato compatibile con telnet.
     * 
     * @param message Il messaggio da inviare ai client.
     */
    public synchronized void send(final String message) {
        for (Socket client : clients) {
            try {
                OutputStream outputStream = client.getOutputStream();
                outputStream.write(message.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                // Gestisci l'eccezione, ad esempio rimuovendo il client dalla lista
                clients.remove(client);
                e.printStackTrace();
            }
        }
    }

    /**
     * Aggiunge un client alla lista dei client connessi.
     * 
     * @param client Il socket del client da aggiungere.
     */
    public synchronized void addClient(Socket client) {
        clients.add(client);
    }

    /**
     * Rimuove un client dalla lista dei client connessi.
     * 
     * @param client Il socket del client da rimuovere.
     */
    public synchronized void removeClient(Socket client) {
        clients.remove(client);
    }
}
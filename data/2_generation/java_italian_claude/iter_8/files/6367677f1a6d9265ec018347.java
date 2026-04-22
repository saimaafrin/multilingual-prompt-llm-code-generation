import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private List<PrintWriter> clientWriters;

    public ChatServer() {
        clientWriters = new ArrayList<>();
    }

    /**
     * Invia un messaggio a ciascuno dei client in un formato compatibile con telnet.
     */
    public synchronized void send(final String message) {
        // Aggiungi newline per compatibilità telnet
        String telnetMessage = message + "\r\n";
        
        // Itera su tutti i client writer
        for (PrintWriter writer : clientWriters) {
            try {
                writer.print(telnetMessage);
                writer.flush();
            } catch (Exception e) {
                // Rimuovi client disconnessi
                clientWriters.remove(writer);
            }
        }
    }

    // Metodo per aggiungere un nuovo client
    public synchronized void addClient(Socket clientSocket) throws IOException {
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        clientWriters.add(writer);
    }
}
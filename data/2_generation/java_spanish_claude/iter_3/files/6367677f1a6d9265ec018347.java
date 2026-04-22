import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<PrintWriter> clientWriters;

    public TelnetServer() {
        clientWriters = new ArrayList<>();
    }

    /**
     * Envía un mensaje a cada uno de los clientes en un formato compatible con telnet.
     */
    public synchronized void send(final String message) {
        // Agregar retorno de carro y salto de línea para compatibilidad telnet
        String telnetMessage = message + "\r\n";
        
        // Iterar sobre la lista de writers de clientes
        List<PrintWriter> disconnectedClients = new ArrayList<>();
        
        for (PrintWriter writer : clientWriters) {
            try {
                writer.print(telnetMessage);
                writer.flush();
            } catch (Exception e) {
                // Si hay error al enviar, agregar cliente a lista de desconectados
                disconnectedClients.add(writer);
            }
        }
        
        // Remover clientes desconectados
        clientWriters.removeAll(disconnectedClients);
    }

    // Método para agregar un nuevo cliente
    public synchronized void addClient(Socket clientSocket) throws IOException {
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        clientWriters.add(writer);
    }
}
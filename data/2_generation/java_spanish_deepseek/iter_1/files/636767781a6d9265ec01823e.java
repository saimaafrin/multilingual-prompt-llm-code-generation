import org.apache.log4j.spi.LoggingEvent;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class LogAppender {
    private List<PrintWriter> clients = new ArrayList<>();

    /**
     * Maneja un evento de registro. Para este "appender", eso significa escribir el mensaje a cada cliente conectado.
     * @param event El evento de registro que contiene el mensaje a enviar.
     */
    protected void append(LoggingEvent event) {
        String message = event.getMessage().toString();
        synchronized (clients) {
            for (PrintWriter client : clients) {
                client.println(message);
                client.flush();
            }
        }
    }

    /**
     * Agrega un nuevo cliente a la lista de clientes conectados.
     * @param clientSocket El socket del cliente que se conecta.
     */
    public void addClient(Socket clientSocket) {
        try {
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            synchronized (clients) {
                clients.add(writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un cliente de la lista de clientes conectados.
     * @param clientSocket El socket del cliente que se desconecta.
     */
    public void removeClient(Socket clientSocket) {
        try {
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            synchronized (clients) {
                clients.remove(writer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
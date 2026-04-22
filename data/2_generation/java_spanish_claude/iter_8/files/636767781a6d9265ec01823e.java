import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SocketAppender extends AppenderSkeleton {
    
    private final List<PrintWriter> clients = new CopyOnWriteArrayList<>();
    
    /**
     * Maneja un evento de registro. Para este "appender", eso significa escribir el mensaje a cada cliente conectado.
     */
    @Override
    protected void append(LoggingEvent event) {
        String message = layout.format(event);
        
        // Iterar sobre la lista de clientes y enviar el mensaje a cada uno
        for (PrintWriter client : clients) {
            try {
                client.println(message);
                client.flush();
            } catch (Exception e) {
                // Si hay un error al escribir, remover el cliente
                clients.remove(client);
            }
        }
    }
    
    // Método para agregar un nuevo cliente
    public void addClient(PrintWriter client) {
        clients.add(client);
    }
    
    // Método para remover un cliente
    public void removeClient(PrintWriter client) {
        clients.remove(client);
    }
    
    @Override
    public void close() {
        // Cerrar todas las conexiones de clientes
        for (PrintWriter client : clients) {
            try {
                client.close();
            } catch (Exception e) {
                // Ignorar errores al cerrar
            }
        }
        clients.clear();
    }
    
    @Override
    public boolean requiresLayout() {
        return true;
    }
}
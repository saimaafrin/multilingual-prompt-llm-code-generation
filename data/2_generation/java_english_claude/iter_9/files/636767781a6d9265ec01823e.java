import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketAppender extends AppenderSkeleton {
    private List<Socket> clients;
    private List<PrintWriter> writers;

    public SocketAppender() {
        clients = new ArrayList<>();
        writers = new ArrayList<>();
    }

    @Override
    protected void append(LoggingEvent event) {
        if (clients.isEmpty()) {
            return;
        }

        String message = layout.format(event);

        // Send message to all connected clients
        List<Integer> disconnectedClients = new ArrayList<>();
        
        for (int i = 0; i < writers.size(); i++) {
            try {
                PrintWriter writer = writers.get(i);
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                // Client likely disconnected, mark for removal
                disconnectedClients.add(i);
            }
        }

        // Remove any disconnected clients
        for (int i = disconnectedClients.size() - 1; i >= 0; i--) {
            int index = disconnectedClients.get(i);
            try {
                clients.get(index).close();
            } catch (IOException e) {
                // Ignore close errors
            }
            clients.remove(index);
            writers.remove(index);
        }
    }

    public void addClient(Socket client) throws IOException {
        clients.add(client);
        writers.add(new PrintWriter(client.getOutputStream()));
    }

    @Override
    public void close() {
        for (Socket client : clients) {
            try {
                client.close();
            } catch (IOException e) {
                // Ignore close errors
            }
        }
        clients.clear();
        writers.clear();
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
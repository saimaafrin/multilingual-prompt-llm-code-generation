import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;
import java.util.List;

public class ClientAppender extends AppenderSkeleton {
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    @Override
    protected void append(LoggingEvent event) {
        String message = layout.format(event);
        for (Client client : clients) {
            client.sendMessage(message);
        }
    }

    @Override
    public void close() {
        // Clean up resources if necessary
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }

    // Dummy Client class for demonstration
    public static class Client {
        public void sendMessage(String message) {
            System.out.println("Sending to client: " + message);
        }
    }
}
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.util.List;
import java.util.ArrayList;

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
        String message = event.getRenderedMessage();
        for (Client client : clients) {
            client.sendMessage(message);
        }
    }

    @Override
    public void close() {
        // Close resources if needed
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    // Client class for demonstration purposes
    public static class Client {
        public void sendMessage(String message) {
            // Logic to send message to the client
            System.out.println("Sending message to client: " + message);
        }
    }
}
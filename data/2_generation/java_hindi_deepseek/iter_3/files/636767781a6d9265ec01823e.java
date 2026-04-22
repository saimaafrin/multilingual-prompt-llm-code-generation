import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;
import java.util.List;

public class CustomAppender extends AppenderSkeleton {
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    protected void append(LoggingEvent event) {
        String message = event.getRenderedMessage();
        for (Client client : clients) {
            client.write(message);
        }
    }

    @Override
    public void close() {
        // Cleanup resources if needed
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    // Assuming a Client class with a write method
    public static class Client {
        public void write(String message) {
            // Implement the logic to write the message to the client
            System.out.println("Writing to client: " + message);
        }
    }
}
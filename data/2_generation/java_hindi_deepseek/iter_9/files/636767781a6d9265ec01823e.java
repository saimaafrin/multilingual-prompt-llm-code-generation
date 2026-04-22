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

    // Dummy Client class for demonstration
    public static class Client {
        public void write(String message) {
            System.out.println("Client received: " + message);
        }
    }
}
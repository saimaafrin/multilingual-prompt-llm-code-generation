import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class CustomAppender extends AppenderSkeleton {

    @Override
    protected void append(LoggingEvent event) {
        // Iterate over all connected clients and write the log message
        for (Client client : connectedClients) {
            client.write(event.getMessage().toString());
        }
    }

    @Override
    public void close() {
        // Clean up resources if needed
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    // Example client class (assuming it exists)
    private static class Client {
        public void write(String message) {
            // Implementation to write the message to the client
            System.out.println("Writing to client: " + message);
        }
    }

    // Example list of connected clients (assuming it exists)
    private List<Client> connectedClients = new ArrayList<>();
}
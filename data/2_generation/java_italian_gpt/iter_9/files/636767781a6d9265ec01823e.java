import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class CustomAppender extends AppenderSkeleton {

    @Override
    protected void append(LoggingEvent event) {
        // Get the message from the logging event
        String message = event.getRenderedMessage();
        
        // Here you would implement the logic to send the message to each connected client
        // For demonstration purposes, we'll just print it to the console
        System.out.println("Logging to clients: " + message);
        
        // Example: Iterate over connected clients and send the message
        // for (Client client : connectedClients) {
        //     client.sendMessage(message);
        // }
    }

    @Override
    public void close() {
        // Clean up resources if necessary
    }

    @Override
    public boolean requiresLayout() {
        return false; // Change to true if you are using a layout
    }
}
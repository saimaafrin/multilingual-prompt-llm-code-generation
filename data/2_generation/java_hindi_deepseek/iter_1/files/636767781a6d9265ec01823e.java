import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;
import java.util.List;

public class CustomAppender extends AppenderSkeleton {
    private List<String> connectedClients = new ArrayList<>();

    public void addClient(String client) {
        connectedClients.add(client);
    }

    @Override
    protected void append(LoggingEvent event) {
        String message = event.getRenderedMessage();
        for (String client : connectedClients) {
            System.out.println("Sending to client " + client + ": " + message);
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
}
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketAppender extends AppenderSkeleton {
    
    private List<Socket> connectedClients;
    private List<PrintWriter> clientWriters;

    public SocketAppender() {
        connectedClients = new ArrayList<>();
        clientWriters = new ArrayList<>();
    }

    @Override
    protected void append(LoggingEvent event) {
        if (event == null) {
            return;
        }

        String logMessage = layout.format(event);

        // Iterate through all connected clients and send the log message
        for (int i = clientWriters.size() - 1; i >= 0; i--) {
            try {
                PrintWriter writer = clientWriters.get(i);
                writer.println(logMessage);
                writer.flush();
            } catch (Exception e) {
                // If there's an error writing to client, remove it from the list
                removeClient(i);
            }
        }
    }

    public void addClient(Socket client) throws IOException {
        if (client != null) {
            connectedClients.add(client);
            clientWriters.add(new PrintWriter(client.getOutputStream(), true));
        }
    }

    private void removeClient(int index) {
        try {
            clientWriters.get(index).close();
            connectedClients.get(index).close();
        } catch (IOException e) {
            // Ignore close exceptions
        }
        clientWriters.remove(index);
        connectedClients.remove(index);
    }

    @Override
    public void close() {
        for (int i = 0; i < connectedClients.size(); i++) {
            removeClient(i);
        }
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
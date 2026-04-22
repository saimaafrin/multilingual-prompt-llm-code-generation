import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
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
        if (event == null) return;

        String formattedMessage = this.layout.format(event);

        // Iterate through all connected clients and send the log message
        for (int i = 0; i < clientWriters.size(); i++) {
            try {
                PrintWriter writer = clientWriters.get(i);
                if (writer != null) {
                    writer.println(formattedMessage);
                    writer.flush();
                }
            } catch (Exception e) {
                // If there's an error writing to a client, remove it
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
            if (index >= 0 && index < connectedClients.size()) {
                connectedClients.get(index).close();
                connectedClients.remove(index);
                clientWriters.get(index).close();
                clientWriters.remove(index);
            }
        } catch (IOException e) {
            // Ignore close errors
        }
    }

    @Override
    public void close() {
        for (int i = connectedClients.size() - 1; i >= 0; i--) {
            removeClient(i);
        }
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
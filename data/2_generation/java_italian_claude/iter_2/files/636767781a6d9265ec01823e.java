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
                writer.println(formattedMessage);
                writer.flush();
            } catch (Exception e) {
                // If there's an error writing to client, remove it
                removeClient(i);
                i--; // Adjust index since we removed an element
            }
        }
    }

    public void addClient(Socket clientSocket) throws IOException {
        connectedClients.add(clientSocket);
        clientWriters.add(new PrintWriter(clientSocket.getOutputStream(), true));
    }

    private void removeClient(int index) {
        try {
            connectedClients.get(index).close();
        } catch (IOException e) {
            // Ignore close errors
        }
        connectedClients.remove(index);
        clientWriters.remove(index);
    }

    @Override
    public void close() {
        if (!closed) {
            closed = true;
            // Close all client connections
            for (Socket socket : connectedClients) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // Ignore close errors
                }
            }
            connectedClients.clear();
            clientWriters.clear();
        }
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
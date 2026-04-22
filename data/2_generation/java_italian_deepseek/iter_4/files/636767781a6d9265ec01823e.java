import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientLogAppender extends AppenderSkeleton {
    private List<PrintWriter> clients = new ArrayList<>();

    public synchronized void addClient(Socket clientSocket) {
        try {
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            clients.add(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void removeClient(PrintWriter writer) {
        clients.remove(writer);
    }

    @Override
    protected void append(LoggingEvent event) {
        String message = layout.format(event);
        synchronized (this) {
            for (PrintWriter client : clients) {
                client.println(message);
            }
        }
    }

    @Override
    public void close() {
        synchronized (this) {
            for (PrintWriter client : clients) {
                client.close();
            }
            clients.clear();
        }
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
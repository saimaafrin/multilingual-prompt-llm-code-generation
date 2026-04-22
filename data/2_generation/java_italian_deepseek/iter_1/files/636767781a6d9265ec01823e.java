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
            clients.add(new PrintWriter(clientSocket.getOutputStream(), true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void append(LoggingEvent event) {
        String message = layout.format(event);
        for (PrintWriter client : clients) {
            client.println(message);
        }
    }

    @Override
    public void close() {
        for (PrintWriter client : clients) {
            client.close();
        }
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
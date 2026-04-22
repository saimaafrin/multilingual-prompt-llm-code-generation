import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class LogAppender extends AppenderSkeleton {
    private List<PrintWriter> clients = new ArrayList<>();
    private ServerSocket serverSocket;

    public LogAppender(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        new Thread(this::acceptClients).start();
    }

    private void acceptClients() {
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                clients.add(writer);
            }
        } catch (IOException e) {
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
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (PrintWriter client : clients) {
            client.close();
        }
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
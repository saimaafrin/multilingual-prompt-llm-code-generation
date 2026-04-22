import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientLogAppender extends AppenderSkeleton {
    private ServerSocket serverSocket;
    private List<PrintWriter> clients = new ArrayList<>();

    public ClientLogAppender() {
        try {
            serverSocket = new ServerSocket(8080); // Porta su cui il server ascolta
            new Thread(this::acceptClients).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void acceptClients() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                synchronized (clients) {
                    clients.add(writer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void append(LoggingEvent event) {
        String message = layout.format(event);
        synchronized (clients) {
            for (PrintWriter writer : clients) {
                writer.println(message);
            }
        }
    }

    @Override
    public void close() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
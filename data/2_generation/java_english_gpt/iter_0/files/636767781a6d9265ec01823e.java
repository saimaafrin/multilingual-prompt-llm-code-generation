import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LogAppender {
    private List<Client> connectedClients = new CopyOnWriteArrayList<>();

    /** 
     * Handles a log event. For this appender, that means writing the message to each connected client.  
     */
    protected void append(LoggingEvent event) {
        String message = event.getMessage();
        for (Client client : connectedClients) {
            client.sendMessage(message);
        }
    }

    public void addClient(Client client) {
        connectedClients.add(client);
    }

    public void removeClient(Client client) {
        connectedClients.remove(client);
    }
}

class LoggingEvent {
    private String message;

    public LoggingEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

class Client {
    private String clientId;

    public Client(String clientId) {
        this.clientId = clientId;
    }

    public void sendMessage(String message) {
        System.out.println("Sending to " + clientId + ": " + message);
    }
}
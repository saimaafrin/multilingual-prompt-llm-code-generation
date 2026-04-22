import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class LoggingEvent {
    private String message;

    public LoggingEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

class Logger {
    private List<Client> clients = new CopyOnWriteArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    protected void append(LoggingEvent event) {
        for (Client client : clients) {
            client.sendMessage(event.getMessage());
        }
    }
}

class Client {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        System.out.println(name + " received: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Client client1 = new Client("Client1");
        Client client2 = new Client("Client2");

        logger.addClient(client1);
        logger.addClient(client2);

        LoggingEvent event = new LoggingEvent("This is a log message.");
        logger.append(event);
    }
}
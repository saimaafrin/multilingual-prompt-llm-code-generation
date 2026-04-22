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

    /**
     * Maneja un evento de registro. Para este "appender", eso significa escribir el mensaje a cada cliente conectado.  
     */
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
        System.out.println("Message to " + name + ": " + message);
    }
}
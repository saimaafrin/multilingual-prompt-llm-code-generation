import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class TelnetServer {
    private List<Socket> clients;

    public TelnetServer(List<Socket> clients) {
        this.clients = clients;
    }

    /** 
     * Envía un mensaje a cada uno de los clientes en un formato compatible con telnet. 
     */
    public synchronized void send(final String message) {
        for (Socket client : clients) {
            try {
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
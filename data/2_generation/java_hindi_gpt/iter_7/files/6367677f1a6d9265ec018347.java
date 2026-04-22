import java.io.PrintWriter;
import java.net.Socket;

public class TelnetClient {
    private Socket socket;
    private PrintWriter out;

    public TelnetClient(String host, int port) throws Exception {
        this.socket = new Socket(host, port);
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    /** 
     * प्रत्येक क्लाइंट को टेलनेट-फ्रेंडली आउटपुट में एक संदेश भेजता है। 
     */
    public synchronized void send(final String message) {
        if (out != null) {
            out.println(message);
        }
    }

    public void close() throws Exception {
        if (out != null) {
            out.close();
        }
        if (socket != null) {
            socket.close();
        }
    }

    public static void main(String[] args) {
        try {
            TelnetClient client = new TelnetClient("localhost", 23);
            client.send("Hello, Telnet!");
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
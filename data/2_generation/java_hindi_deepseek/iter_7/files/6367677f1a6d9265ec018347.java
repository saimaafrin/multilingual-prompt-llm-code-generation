import java.io.PrintWriter;
import java.net.Socket;

public class TelnetClient {
    private final Socket socket;
    private final PrintWriter out;

    public TelnetClient(Socket socket) throws Exception {
        this.socket = socket;
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
}
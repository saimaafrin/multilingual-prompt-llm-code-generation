import java.io.PrintWriter;
import java.net.Socket;

public class TelnetClient {
    private PrintWriter out;

    public TelnetClient(Socket socket) throws Exception {
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
}
import java.io.PrintWriter;
import java.net.Socket;

public class TelnetClientHandler {
    private final Socket clientSocket;
    private final PrintWriter out;

    public TelnetClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    /**
     * प्रत्येक क्लाइंट को टेलनेट-फ्रेंडली आउटपुट में एक संदेश भेजता है।
     */
    public synchronized void send(final String message) {
        if (out != null) {
            out.println(message);
        }
    }

    public void close() throws IOException {
        if (out != null) {
            out.close();
        }
        if (clientSocket != null) {
            clientSocket.close();
        }
    }
}
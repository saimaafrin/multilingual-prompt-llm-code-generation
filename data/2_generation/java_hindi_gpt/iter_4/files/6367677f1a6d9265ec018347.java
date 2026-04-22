import java.io.PrintWriter;
import java.net.Socket;

public class TelnetServer {
    private Socket clientSocket;
    private PrintWriter out;

    public TelnetServer(Socket socket) {
        this.clientSocket = socket;
        try {
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 
     * प्रत्येक क्लाइंट को टेलनेट-फ्रेंडली आउटपुट में एक संदेश भेजता है। 
     */
    public synchronized void send(final String message) {
        if (out != null) {
            out.println(message);
        }
    }

    public void close() {
        try {
            if (out != null) {
                out.close();
            }
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
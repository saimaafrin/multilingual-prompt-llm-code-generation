import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<Socket> clients = new ArrayList<>();

    /**
     * 以适用于 Telnet 的格式向每个客户端发送消息。
     * @param message 要发送的消息
     */
    public synchronized void send(final String message) {
        for (Socket client : clients) {
            try {
                OutputStream outputStream = client.getOutputStream();
                outputStream.write(message.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                // 处理客户端连接异常
                e.printStackTrace();
            }
        }
    }

    /**
     * 添加客户端到列表中。
     * @param client 客户端Socket
     */
    public synchronized void addClient(Socket client) {
        clients.add(client);
    }

    /**
     * 从列表中移除客户端。
     * @param client 客户端Socket
     */
    public synchronized void removeClient(Socket client) {
        clients.remove(client);
    }
}
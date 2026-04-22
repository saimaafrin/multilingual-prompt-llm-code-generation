import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TelnetServer {
    private List<PrintWriter> clientWriters = new ArrayList<>();
    
    /**
     * 以适用于 Telnet 的格式向每个客户端发送消息。
     */
    public synchronized void send(final String message) {
        // 遍历所有客户端的输出流
        for (PrintWriter writer : clientWriters) {
            try {
                // 发送消息,添加回车换行符以适配Telnet协议
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                // 如果发送失败,从列表中移除该客户端
                clientWriters.remove(writer);
            }
        }
    }
    
    // 添加新的客户端连接
    public synchronized void addClient(PrintWriter writer) {
        clientWriters.add(writer);
    }
    
    // 移除客户端连接
    public synchronized void removeClient(PrintWriter writer) {
        clientWriters.remove(writer);
    }
}
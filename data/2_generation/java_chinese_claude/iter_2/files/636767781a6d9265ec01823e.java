import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketAppender extends AppenderSkeleton {
    
    private List<Socket> clients = new ArrayList<>();
    private List<PrintWriter> writers = new ArrayList<>();

    @Override
    protected void append(LoggingEvent event) {
        // 获取日志消息
        String message = layout.format(event);
        
        // 遍历所有连接的客户端
        for (int i = 0; i < writers.size(); i++) {
            try {
                PrintWriter writer = writers.get(i);
                // 检查连接是否仍然有效
                if (clients.get(i).isConnected()) {
                    writer.println(message);
                    writer.flush();
                } else {
                    // 移除断开连接的客户端
                    writer.close();
                    clients.get(i).close();
                    clients.remove(i);
                    writers.remove(i);
                    i--;
                }
            } catch (IOException e) {
                // 处理写入错误
                try {
                    clients.get(i).close();
                } catch (IOException ex) {
                    // 忽略关闭错误
                }
                clients.remove(i);
                writers.remove(i);
                i--;
            }
        }
    }

    // 添加新的客户端连接
    public void addClient(Socket client) throws IOException {
        clients.add(client);
        writers.add(new PrintWriter(client.getOutputStream(), true));
    }

    @Override
    public void close() {
        // 关闭所有连接
        for (int i = 0; i < clients.size(); i++) {
            try {
                writers.get(i).close();
                clients.get(i).close();
            } catch (IOException e) {
                // 忽略关闭错误
            }
        }
        clients.clear();
        writers.clear();
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
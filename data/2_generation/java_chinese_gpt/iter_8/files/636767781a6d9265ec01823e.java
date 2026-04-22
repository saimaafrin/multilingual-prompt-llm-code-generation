import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class LogAppender {
    private List<Socket> clientSockets;

    public LogAppender(List<Socket> clientSockets) {
        this.clientSockets = clientSockets;
    }

    /**
     * 处理日志事件。对于这个appender，这意味着将消息写入每个连接的客户端。
     */
    protected void append(LoggingEvent event) {
        String message = event.getMessage();
        for (Socket clientSocket : clientSockets) {
            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class LoggingEvent {
    private String message;

    public LoggingEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;
import java.util.List;

public class LogBuffer {
    private List<LoggingEvent> buffer;
    private static final int MAX_BUFFER_SIZE = 1000;

    public LogBuffer() {
        buffer = new ArrayList<>();
    }

    /**
     * 将一个<code>event</code>添加为缓冲区中的最后一个事件。
     */
    public void add(LoggingEvent event) {
        if (event == null) {
            return;
        }

        // 如果缓冲区达到最大容量,删除最早的事件
        if (buffer.size() >= MAX_BUFFER_SIZE) {
            buffer.remove(0);
        }

        // 添加新事件到缓冲区末尾
        buffer.add(event);
    }
}
import java.util.concurrent.ArrayBlockingQueue;
import ch.qos.logback.classic.spi.LoggingEvent;

public class LogBuffer {
    private final ArrayBlockingQueue<LoggingEvent> buffer;
    private static final int DEFAULT_BUFFER_SIZE = 1000;

    public LogBuffer() {
        this(DEFAULT_BUFFER_SIZE);
    }

    public LogBuffer(int bufferSize) {
        buffer = new ArrayBlockingQueue<>(bufferSize);
    }

    /** 
     * 将一个 {@link LoggingEvent} 放入缓冲区。如果缓冲区已满，则该事件会被<b>静默丢弃</b>。调用者有责任确保缓冲区有空闲空间。  
     */
    public void put(LoggingEvent o) {
        if (o != null) {
            buffer.offer(o); // Using offer() instead of put() to avoid blocking
        }
    }
}
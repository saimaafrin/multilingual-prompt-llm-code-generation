import org.apache.log4j.spi.LoggingEvent;
import java.util.concurrent.ArrayBlockingQueue;

public class LogBuffer {
    private ArrayBlockingQueue<LoggingEvent> buffer;
    private static final int DEFAULT_BUFFER_SIZE = 1000;

    public LogBuffer() {
        this(DEFAULT_BUFFER_SIZE);
    }

    public LogBuffer(int bufferSize) {
        buffer = new ArrayBlockingQueue<>(bufferSize);
    }

    public void put(LoggingEvent event) {
        if (event != null) {
            buffer.offer(event); // Silently drops if buffer is full
        }
    }
}
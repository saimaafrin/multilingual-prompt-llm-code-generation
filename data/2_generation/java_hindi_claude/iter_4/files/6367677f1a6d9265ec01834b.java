import org.apache.log4j.spi.LoggingEvent;
import java.util.concurrent.ArrayBlockingQueue;

public class LogEventBuffer {
    private final ArrayBlockingQueue<LoggingEvent> buffer;
    private static final int DEFAULT_BUFFER_SIZE = 1000;

    public LogEventBuffer() {
        this(DEFAULT_BUFFER_SIZE);
    }

    public LogEventBuffer(int bufferSize) {
        buffer = new ArrayBlockingQueue<>(bufferSize);
    }

    public void put(LoggingEvent event) {
        if (event != null) {
            buffer.offer(event); // Silently drops if buffer is full
        }
    }

    public LoggingEvent take() throws InterruptedException {
        return buffer.take();
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    public int size() {
        return buffer.size();
    }

    public void clear() {
        buffer.clear();
    }
}
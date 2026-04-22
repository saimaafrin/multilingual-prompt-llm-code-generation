import org.apache.log4j.spi.LoggingEvent;
import java.util.concurrent.ArrayBlockingQueue;

public class LogEventBuffer {
    private final ArrayBlockingQueue<LoggingEvent> buffer;
    private final int maxSize;

    public LogEventBuffer(int size) {
        this.maxSize = size;
        this.buffer = new ArrayBlockingQueue<>(maxSize);
    }

    /**
     * Add an <code>event</code> as the last event in the buffer.
     */
    public void add(LoggingEvent event) {
        if (event == null) {
            return;
        }

        // If buffer is full, remove oldest event
        if (buffer.size() == maxSize) {
            buffer.poll();
        }

        // Add new event to buffer
        buffer.offer(event);
    }
}
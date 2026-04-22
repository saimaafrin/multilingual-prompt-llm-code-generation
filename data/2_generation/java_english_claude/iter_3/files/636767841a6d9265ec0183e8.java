import org.apache.log4j.spi.LoggingEvent;
import java.util.concurrent.ArrayBlockingQueue;

public class LogEventBuffer {
    private final ArrayBlockingQueue<LoggingEvent> buffer;
    private final int capacity;

    public LogEventBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new ArrayBlockingQueue<>(capacity);
    }

    /**
     * Add an <code>event</code> as the last event in the buffer.
     */
    public void add(LoggingEvent event) {
        if (event == null) {
            return;
        }

        // If buffer is full, remove oldest event
        if (buffer.size() == capacity) {
            buffer.poll();
        }

        // Add new event
        buffer.offer(event);
    }
}
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LogBuffer {
    private final BlockingQueue<LoggingEvent> buffer;

    public LogBuffer(int capacity) {
        this.buffer = new ArrayBlockingQueue<>(capacity);
    }

    /**
     * Place a {@link LoggingEvent} in the buffer. If the buffer is full then the event is <b>silently dropped</b>.
     * It is the caller's responsibility to make sure that the buffer has free space.
     *
     * @param o the LoggingEvent to be placed in the buffer
     */
    public void put(LoggingEvent o) {
        if (!buffer.offer(o)) {
            // Silently drop the event if the buffer is full
        }
    }
}

class LoggingEvent {
    // LoggingEvent implementation details
}
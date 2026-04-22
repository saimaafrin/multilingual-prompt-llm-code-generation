import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LogBuffer {
    private final BlockingQueue<LoggingEvent> buffer;

    public LogBuffer(int capacity) {
        this.buffer = new ArrayBlockingQueue<>(capacity);
    }

    /**
     * Inserisce un {@link LoggingEvent} nel buffer. Se il buffer è pieno, l'evento viene <b>silenziosamente scartato</b>.
     * È responsabilità del chiamante assicurarsi che il buffer abbia spazio libero.
     */
    public void put(LoggingEvent o) {
        if (!buffer.offer(o)) {
            // Silently discard the event if the buffer is full
        }
    }

    // Optional: Method to retrieve events from the buffer
    public LoggingEvent take() throws InterruptedException {
        return buffer.take();
    }
}

// Assuming LoggingEvent is a class defined elsewhere
class LoggingEvent {
    // Implementation of LoggingEvent
}
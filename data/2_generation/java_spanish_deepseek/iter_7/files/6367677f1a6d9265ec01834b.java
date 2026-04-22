import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LogBuffer {
    private final BlockingQueue<LoggingEvent> buffer;

    public LogBuffer(int capacity) {
        this.buffer = new ArrayBlockingQueue<>(capacity);
    }

    /**
     * Coloca un {@link LoggingEvent} en el búfer. Si el búfer está lleno, el evento es <b>silenciosamente descartado</b>.
     * Es responsabilidad del llamador asegurarse de que el búfer tenga espacio libre.
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

// Assuming LoggingEvent is a simple class for demonstration purposes
class LoggingEvent {
    private final String message;

    public LoggingEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
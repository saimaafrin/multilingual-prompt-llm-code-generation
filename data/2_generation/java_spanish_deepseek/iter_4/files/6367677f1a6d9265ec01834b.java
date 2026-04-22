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

    // Assuming LoggingEvent is a class that represents a logging event
    public static class LoggingEvent {
        // Implementation of LoggingEvent class
    }
}
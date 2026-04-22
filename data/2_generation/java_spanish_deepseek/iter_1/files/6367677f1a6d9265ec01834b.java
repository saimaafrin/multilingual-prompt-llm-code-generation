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
}

class LoggingEvent {
    // Assume LoggingEvent is a class with necessary fields and methods
}
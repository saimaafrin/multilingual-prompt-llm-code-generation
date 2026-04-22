import org.apache.log4j.spi.LoggingEvent;
import java.util.concurrent.ArrayBlockingQueue;

public class LogBuffer {
    private final ArrayBlockingQueue<LoggingEvent> buffer;
    private static final int DEFAULT_BUFFER_SIZE = 1000;

    public LogBuffer() {
        this(DEFAULT_BUFFER_SIZE);
    }

    public LogBuffer(int capacity) {
        buffer = new ArrayBlockingQueue<>(capacity);
    }

    /**
     * Inserisce un {@link LoggingEvent} nel buffer. Se il buffer è pieno, l'evento viene 
     * <b>silenziosamente scartato</b>. È responsabilità del chiamante assicurarsi che 
     * il buffer abbia spazio libero.
     */
    public void put(LoggingEvent o) {
        if (o != null) {
            buffer.offer(o); // Uses offer() instead of add() to silently discard when full
        }
    }
}
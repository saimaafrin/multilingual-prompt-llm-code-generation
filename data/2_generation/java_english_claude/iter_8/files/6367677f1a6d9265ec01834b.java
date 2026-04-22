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

    /** 
     * Place a {@link LoggingEvent} in the buffer. If the buffer is full
     * then the event is <b>silently dropped</b>. It is the caller's 
     * responsability to make sure that the buffer has free space.  
     */
    public void put(LoggingEvent o) {
        if (o != null) {
            buffer.offer(o); // Uses offer() instead of add() to silently drop when full
        }
    }
}
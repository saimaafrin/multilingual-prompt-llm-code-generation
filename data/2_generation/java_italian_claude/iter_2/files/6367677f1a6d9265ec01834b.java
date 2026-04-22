import org.apache.log4j.spi.LoggingEvent;
import java.util.concurrent.ArrayBlockingQueue;

public class LogBuffer {
    private ArrayBlockingQueue<LoggingEvent> buffer;
    private final int capacity;

    public LogBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new ArrayBlockingQueue<>(capacity);
    }

    /** 
     * Inserisce un {@link LoggingEvent} nel buffer. Se il buffer è pieno, l'evento viene <b>silenziosamente scartato</b>.
     * È responsabilità del chiamante assicurarsi che il buffer abbia spazio libero.  
     */
    public void put(LoggingEvent o) {
        if (o != null) {
            buffer.offer(o); // offer() silently fails if buffer is full
        }
    }
}
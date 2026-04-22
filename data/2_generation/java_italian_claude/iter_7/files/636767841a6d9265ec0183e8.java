import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;

public class LogBuffer {
    private ArrayList<LoggingEvent> buffer;
    private static final int MAX_BUFFER_SIZE = 1000;

    public LogBuffer() {
        buffer = new ArrayList<LoggingEvent>();
    }

    /**
     * Aggiunge un <code>evento</code> come ultimo evento nel buffer.
     */
    public void add(LoggingEvent event) {
        if (event == null) {
            return;
        }

        // Add event to end of buffer
        buffer.add(event);

        // If buffer exceeds max size, remove oldest event
        if (buffer.size() > MAX_BUFFER_SIZE) {
            buffer.remove(0);
        }
    }
}
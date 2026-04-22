import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;
import java.util.List;

public class LogBuffer {
    private List<LoggingEvent> buffer;
    private static final int MAX_BUFFER_SIZE = 1000;

    public LogBuffer() {
        buffer = new ArrayList<>();
    }

    /**
     * Agrega un <code>evento</code> como el último evento en el búfer.
     */
    public void add(LoggingEvent event) {
        if (event == null) {
            return;
        }

        // Remove oldest event if buffer is full
        if (buffer.size() >= MAX_BUFFER_SIZE) {
            buffer.remove(0);
        }

        // Add new event to end of buffer
        buffer.add(event);
    }
}
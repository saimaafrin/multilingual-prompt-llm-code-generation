import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;
import java.util.List;

public class EventBuffer {
    private List<LoggingEvent> buffer;

    public EventBuffer() {
        buffer = new ArrayList<>();
    }

    /** 
     * Aggiunge un <code>evento</code> come ultimo evento nel buffer.
     */
    public void add(LoggingEvent event) {
        if (event != null) {
            buffer.add(event);
        }
    }

    // Optional: Method to get the buffer for testing or other purposes
    public List<LoggingEvent> getBuffer() {
        return buffer;
    }
}
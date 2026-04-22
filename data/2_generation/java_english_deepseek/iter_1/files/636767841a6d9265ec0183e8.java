import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;
import java.util.List;

public class EventBuffer {
    private List<LoggingEvent> buffer;

    public EventBuffer() {
        this.buffer = new ArrayList<>();
    }

    /**
     * Add an <code>event</code> as the last event in the buffer.
     */
    public void add(LoggingEvent event) {
        if (event != null) {
            buffer.add(event);
        }
    }

    // Optional: Method to retrieve the buffer for testing or other purposes
    public List<LoggingEvent> getBuffer() {
        return buffer;
    }
}
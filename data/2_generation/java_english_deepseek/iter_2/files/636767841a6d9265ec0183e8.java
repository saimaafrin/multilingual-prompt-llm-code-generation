import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;
import java.util.List;

public class EventBuffer {
    private List<LoggingEvent> buffer;

    public EventBuffer() {
        buffer = new ArrayList<>();
    }

    /**
     * Add an <code>event</code> as the last event in the buffer.
     */
    public void add(LoggingEvent event) {
        buffer.add(event);
    }
}
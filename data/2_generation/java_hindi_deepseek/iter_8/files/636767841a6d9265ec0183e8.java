import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;
import java.util.List;

public class EventBuffer {
    private List<LoggingEvent> buffer;

    public EventBuffer() {
        this.buffer = new ArrayList<>();
    }

    /**
     * एक <code>event</code> को बफर में अंतिम घटना के रूप में जोड़ें।
     */
    public void add(LoggingEvent event) {
        if (event != null) {
            buffer.add(event);
        }
    }

    public List<LoggingEvent> getBuffer() {
        return buffer;
    }
}
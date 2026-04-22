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
        buffer.add(event);
    }

    // Assuming LoggingEvent is a predefined class
    public static class LoggingEvent {
        // Example fields and methods for LoggingEvent
        private String message;

        public LoggingEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
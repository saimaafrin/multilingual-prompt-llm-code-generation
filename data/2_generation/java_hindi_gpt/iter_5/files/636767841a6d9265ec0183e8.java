import java.util.LinkedList;

public class EventBuffer {
    private LinkedList<LoggingEvent> buffer;

    public EventBuffer() {
        buffer = new LinkedList<>();
    }

    /** 
     * एक <code>event</code> को बफर में अंतिम घटना के रूप में जोड़ें।
     */
    public void add(LoggingEvent event) {
        buffer.addLast(event);
    }
}

class LoggingEvent {
    // Assuming LoggingEvent has some properties and methods
    private String message;

    public LoggingEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
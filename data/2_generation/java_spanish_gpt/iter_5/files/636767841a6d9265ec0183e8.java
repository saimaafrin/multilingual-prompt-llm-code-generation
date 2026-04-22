import java.util.LinkedList;

public class EventLogger {
    private LinkedList<LoggingEvent> eventBuffer;

    public EventLogger() {
        eventBuffer = new LinkedList<>();
    }

    /** 
     * Agrega un <code>evento</code> como el último evento en el búfer.
     */
    public void add(LoggingEvent event) {
        eventBuffer.addLast(event);
    }
}

class LoggingEvent {
    private String message;

    public LoggingEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
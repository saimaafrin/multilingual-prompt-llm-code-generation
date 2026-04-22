import java.util.LinkedList;

public class EventBuffer {
    private LinkedList<LoggingEvent> buffer;

    public EventBuffer() {
        buffer = new LinkedList<>();
    }

    /** 
     * Add an <code>event</code> as the last event in the buffer.
     */
    public void add(LoggingEvent event) {
        buffer.addLast(event);
    }
}

class LoggingEvent {
    // Assume this class has some properties and methods
}
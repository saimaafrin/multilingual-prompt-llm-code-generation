import java.util.LinkedList;

public class LoggingBuffer {
    private LinkedList<LoggingEvent> buffer;
    private int capacity;

    public LoggingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    /** 
     * Place a  {@link LoggingEvent} in the buffer. If the buffer is full then the event is <b>silently dropped</b>. 
     * It is the caller's responsability to make sure that the buffer has free space.  
     */
    public void put(LoggingEvent o) {
        if (buffer.size() < capacity) {
            buffer.add(o);
        }
        // If the buffer is full, the event is silently dropped
    }
}

class LoggingEvent {
    // Assume this class has some properties and methods relevant to logging events
}
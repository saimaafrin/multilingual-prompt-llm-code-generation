import java.util.LinkedList;
import java.util.Queue;

public class LoggingBuffer {
    private final Queue<LoggingEvent> buffer;
    private final int capacity;

    public LoggingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    /** 
     * Inserisce un {@link LoggingEvent} nel buffer. Se il buffer è pieno, l'evento viene <b>silenziosamente scartato</b>. È responsabilità del chiamante assicurarsi che il buffer abbia spazio libero.  
     */
    public void put(LoggingEvent o) {
        if (buffer.size() < capacity) {
            buffer.offer(o);
        }
        // If the buffer is full, the event is silently discarded.
    }

    // Additional methods for demonstration purposes
    public int size() {
        return buffer.size();
    }

    public boolean isFull() {
        return buffer.size() >= capacity;
    }
}

class LoggingEvent {
    // Implementation of LoggingEvent class
}
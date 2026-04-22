import java.util.LinkedList;

public class LoggingBuffer {
    private LinkedList<LoggingEvent> buffer;
    private int capacity;

    public LoggingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    /** 
     * Inserisce un {@link LoggingEvent} nel buffer. Se il buffer è pieno, l'evento viene <b>silenziosamente scartato</b>. È responsabilità del chiamante assicurarsi che il buffer abbia spazio libero.  
     */
    public void put(LoggingEvent o) {
        if (buffer.size() < capacity) {
            buffer.add(o);
        }
        // If the buffer is full, the event is silently discarded
    }
}

class LoggingEvent {
    // Assume this class has necessary fields and methods
}
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

    // Additional methods for demonstration purposes
    public int size() {
        return buffer.size();
    }

    public static class LoggingEvent {
        private String message;

        public LoggingEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static void main(String[] args) {
        LoggingBuffer loggingBuffer = new LoggingBuffer(5);
        loggingBuffer.put(new LoggingEvent("Event 1"));
        loggingBuffer.put(new LoggingEvent("Event 2"));
        System.out.println("Current buffer size: " + loggingBuffer.size());
    }
}
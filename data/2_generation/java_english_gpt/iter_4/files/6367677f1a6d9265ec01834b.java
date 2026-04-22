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
     * Place a  {@link LoggingEvent} in the buffer. If the buffer is full then the event is <b>silently dropped</b>. 
     * It is the caller's responsability to make sure that the buffer has free space.  
     */
    public void put(LoggingEvent o) {
        if (buffer.size() < capacity) {
            buffer.offer(o);
        }
        // If the buffer is full, the event is silently dropped
    }

    // Additional methods for demonstration purposes
    public int size() {
        return buffer.size();
    }

    public boolean isFull() {
        return buffer.size() >= capacity;
    }

    public static class LoggingEvent {
        // Implementation of LoggingEvent class
        private final String message;

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
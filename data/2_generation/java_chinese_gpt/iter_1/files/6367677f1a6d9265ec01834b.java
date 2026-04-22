import java.util.LinkedList;

public class LoggingBuffer {
    private LinkedList<LoggingEvent> buffer;
    private int capacity;

    public LoggingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    /** 
     * 将一个 {@link LoggingEvent} 放入缓冲区。如果缓冲区已满，则该事件会被<b>静默丢弃</b>。调用者有责任确保缓冲区有空闲空间。  
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
        // Implementation of LoggingEvent class
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
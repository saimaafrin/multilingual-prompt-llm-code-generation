import java.util.LinkedList;

public class LoggingBuffer {
    private LinkedList<LoggingEvent> buffer;
    private int capacity;

    public LoggingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    /** 
     * एक {@link LoggingEvent} को बफर में रखें। यदि बफर भर गया है तो घटना <b>चुपचाप हटा दी जाती है</b>। यह कॉलर की जिम्मेदारी है कि वह सुनिश्चित करे कि बफर में खाली स्थान है।  
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
        LoggingBuffer loggingBuffer = new LoggingBuffer(2);
        loggingBuffer.put(new LoggingEvent("Event 1"));
        loggingBuffer.put(new LoggingEvent("Event 2"));
        loggingBuffer.put(new LoggingEvent("Event 3")); // This will be discarded

        System.out.println("Buffer size: " + loggingBuffer.size()); // Should print 2
    }
}
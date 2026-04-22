import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LogBuffer {
    private final BlockingQueue<LoggingEvent> buffer;

    public LogBuffer(int capacity) {
        this.buffer = new ArrayBlockingQueue<>(capacity);
    }

    /**
     * एक {@link LoggingEvent} को बफर में रखें। यदि बफर भर गया है तो घटना <b>चुपचाप हटा दी जाती है</b>। यह कॉलर की जिम्मेदारी है कि वह सुनिश्चित करे कि बफर में खाली स्थान है।
     */
    public void put(LoggingEvent o) {
        if (!buffer.offer(o)) {
            // बफर भरा हुआ है, घटना को चुपचाप हटा दें
            System.out.println("Buffer is full, event discarded: " + o);
        }
    }

    // LoggingEvent class (assuming it exists)
    public static class LoggingEvent {
        // Example implementation of LoggingEvent
        private final String message;

        public LoggingEvent(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "LoggingEvent{" +
                    "message='" + message + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        LogBuffer logBuffer = new LogBuffer(10);

        // Example usage
        for (int i = 0; i < 15; i++) {
            logBuffer.put(new LoggingEvent("Event " + i));
        }
    }
}
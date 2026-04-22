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
            // If the buffer is full, the event is silently dropped
            System.out.println("Buffer is full, dropping event: " + o);
        }
    }

    // Example LoggingEvent class
    public static class LoggingEvent {
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

        for (int i = 0; i < 15; i++) {
            logBuffer.put(new LoggingEvent("Event " + i));
        }
    }
}
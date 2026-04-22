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

    // Additional methods can be added here for buffer management
}

class LoggingEvent {
    // Assume this class has necessary fields and methods
}
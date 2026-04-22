import java.util.LinkedList;

public class LoggingBuffer {
    private LinkedList<LoggingEvent> buffer;
    private int maxSize;

    public LoggingBuffer(int maxSize) {
        this.maxSize = maxSize;
        this.buffer = new LinkedList<>();
    }

    /** 
     * एक {@link LoggingEvent} को बफर में रखें। यदि बफर भर गया है तो घटना <b>चुपचाप हटा दी जाती है</b>। यह कॉलर की जिम्मेदारी है कि वह सुनिश्चित करे कि बफर में खाली स्थान है।  
     */
    public void put(LoggingEvent o) {
        if (buffer.size() < maxSize) {
            buffer.add(o);
        } 
        // If the buffer is full, the event is silently discarded
    }
}

class LoggingEvent {
    // Assume this class has some properties and methods relevant to logging events
}
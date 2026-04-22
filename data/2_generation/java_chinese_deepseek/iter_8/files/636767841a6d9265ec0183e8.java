import org.apache.log4j.spi.LoggingEvent;

public class EventBuffer {
    private LoggingEvent[] buffer;
    private int size;
    private int capacity;

    public EventBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LoggingEvent[capacity];
        this.size = 0;
    }

    /**
     * 将一个<code>event</code>添加为缓冲区中的最后一个事件。
     */
    public void add(LoggingEvent event) {
        if (size < capacity) {
            buffer[size] = event;
            size++;
        } else {
            // If the buffer is full, we can either throw an exception or resize the buffer.
            // Here, we choose to resize the buffer by doubling its capacity.
            int newCapacity = capacity * 2;
            LoggingEvent[] newBuffer = new LoggingEvent[newCapacity];
            System.arraycopy(buffer, 0, newBuffer, 0, size);
            buffer = newBuffer;
            capacity = newCapacity;
            buffer[size] = event;
            size++;
        }
    }

    // Optional: Method to get the current size of the buffer
    public int size() {
        return size;
    }

    // Optional: Method to get the buffer capacity
    public int capacity() {
        return capacity;
    }
}
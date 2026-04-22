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
            // 如果缓冲区已满，可以选择覆盖最早的事件或者抛出异常
            // 这里选择覆盖最早的事件
            System.arraycopy(buffer, 1, buffer, 0, size - 1);
            buffer[size - 1] = event;
        }
    }

    // 其他方法，如获取缓冲区大小、获取事件等
    public int getSize() {
        return size;
    }

    public LoggingEvent getEvent(int index) {
        if (index >= 0 && index < size) {
            return buffer[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }
}
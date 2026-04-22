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
        // 如果缓冲区已满，事件将被静默丢弃
    }

    // 其他可能的方法，例如获取缓冲区内容等
}

class LoggingEvent {
    // 假设 LoggingEvent 类的实现
}
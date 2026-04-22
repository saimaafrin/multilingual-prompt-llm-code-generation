import java.util.LinkedList;

public class EventBuffer {
    private LinkedList<LoggingEvent> buffer;

    public EventBuffer() {
        buffer = new LinkedList<>();
    }

    /** 
     * 将一个<code>event</code>添加为缓冲区中的最后一个事件。
     */
    public void add(LoggingEvent event) {
        buffer.addLast(event);
    }
}

class LoggingEvent {
    // Assume this class has necessary fields and methods
}
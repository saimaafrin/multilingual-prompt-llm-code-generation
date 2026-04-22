import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LogBuffer {
    private final BlockingQueue<LoggingEvent> buffer;

    public LogBuffer(int capacity) {
        this.buffer = new ArrayBlockingQueue<>(capacity);
    }

    /**
     * 将一个 {@link LoggingEvent} 放入缓冲区。如果缓冲区已满，则该事件会被<b>静默丢弃</b>。调用者有责任确保缓冲区有空闲空间。
     */
    public void put(LoggingEvent o) {
        if (!buffer.offer(o)) {
            // 如果缓冲区已满，静默丢弃事件
            // 这里可以选择记录日志或进行其他处理
        }
    }

    // 其他方法，如从缓冲区取出事件等
}
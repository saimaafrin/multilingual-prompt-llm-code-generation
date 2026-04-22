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

    // Assuming LoggingEvent is a class defined elsewhere
    public static class LoggingEvent {
        private String message;

        public LoggingEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
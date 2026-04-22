import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * Produces a formatted string as specified by the conversion pattern.
     * @param event The LoggingEvent containing the log information.
     * @return A formatted string representing the log event.
     */
    public String format(LoggingEvent event) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));
        String level = event.getLevel().toString();
        String message = event.getMessage();

        return String.format("[%s] %s: %s", timestamp, level, message);
    }

    // Assuming LoggingEvent class structure for demonstration purposes
    public static class LoggingEvent {
        private long timeStamp;
        private Level level;
        private String message;

        public LoggingEvent(long timeStamp, Level level, String message) {
            this.timeStamp = timeStamp;
            this.level = level;
            this.message = message;
        }

        public long getTimeStamp() {
            return timeStamp;
        }

        public Level getLevel() {
            return level;
        }

        public String getMessage() {
            return message;
        }
    }

    // Assuming Level enum for demonstration purposes
    public enum Level {
        INFO, WARN, ERROR, DEBUG
    }

    public static void main(String[] args) {
        LogFormatter formatter = new LogFormatter();
        LoggingEvent event = new LoggingEvent(System.currentTimeMillis(), Level.INFO, "This is a log message.");
        System.out.println(formatter.format(event));
    }
}
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * रूपांतर पैटर्न द्वारा निर्दिष्ट एक स्वरूपित स्ट्रिंग उत्पन्न करता है।
     * 
     * @param event लॉगिंग इवेंट जिसे स्वरूपित करना है
     * @return स्वरूपित स्ट्रिंग
     */
    public String format(LoggingEvent event) {
        // Example format: [timestamp] [level] message
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));
        String level = event.getLevel().toString();
        String message = event.getMessage();

        return String.format("[%s] [%s] %s", timestamp, level, message);
    }

    // Example LoggingEvent class (assuming it exists)
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

    // Example Level enum (assuming it exists)
    public enum Level {
        INFO, WARN, ERROR, DEBUG
    }

    public static void main(String[] args) {
        LogFormatter formatter = new LogFormatter();
        LoggingEvent event = new LoggingEvent(System.currentTimeMillis(), Level.INFO, "This is a log message.");
        System.out.println(formatter.format(event));
    }
}
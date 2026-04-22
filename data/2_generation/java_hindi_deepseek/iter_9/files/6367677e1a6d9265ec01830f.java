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
        // Example pattern: [timestamp] [level] [message]
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));
        String level = event.getLevel().toString();
        String message = event.getMessage();

        return String.format("[%s] [%s] %s", timestamp, level, message);
    }
}

// Assuming LoggingEvent class exists with the following structure:
class LoggingEvent {
    private long timeStamp;
    private String level;
    private String message;

    public LoggingEvent(long timeStamp, String level, String message) {
        this.timeStamp = timeStamp;
        this.level = level;
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
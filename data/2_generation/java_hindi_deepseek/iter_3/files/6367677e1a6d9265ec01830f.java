import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggingEvent {
    private String message;
    private Date timestamp;

    public LoggingEvent(String message, Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

public class LogFormatter {

    /**
     * रूपांतर पैटर्न द्वारा निर्दिष्ट एक स्वरूपित स्ट्रिंग उत्पन्न करता है।
     */
    public String format(LoggingEvent event) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(event.getTimestamp());
        return String.format("[%s] %s", formattedDate, event.getMessage());
    }
}
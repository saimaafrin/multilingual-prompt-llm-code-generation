import org.apache.log4j.spi.LoggingEvent;

public class StringFormatter {
    
    /** 
     * रूपांतर पैटर्न द्वारा निर्दिष्ट एक स्वरूपित स्ट्रिंग उत्पन्न करता है।
     */
    public String format(LoggingEvent event) {
        StringBuilder formattedString = new StringBuilder();
        
        // Example formatting logic
        formattedString.append("Timestamp: ").append(event.getTimeStamp()).append("\n");
        formattedString.append("Level: ").append(event.getLevel()).append("\n");
        formattedString.append("Message: ").append(event.getMessage()).append("\n");
        formattedString.append("Logger: ").append(event.getLoggerName()).append("\n");
        
        return formattedString.toString();
    }
}
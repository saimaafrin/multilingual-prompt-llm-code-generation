import java.util.HashMap;
import java.util.Map;

public class Logger {
    private Map<String, Integer> messageTimestamps;
    private static final int THROTTLE_WINDOW = 10; // 10 second window
    
    public Logger() {
        messageTimestamps = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        // If message has never been printed before, allow it
        if (!messageTimestamps.containsKey(message)) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        // Get last timestamp this message was printed
        int lastPrinted = messageTimestamps.get(message);
        
        // If enough time has elapsed since last print, allow it
        if (timestamp - lastPrinted >= THROTTLE_WINDOW) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        // Otherwise throttle the message
        return false;
    }
}
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private Map<String, Integer> messageTimestamps;
    private static final int THROTTLE_WINDOW = 10; // 10 second window
    
    public Logger() {
        messageTimestamps = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        // If message has never been printed before or the throttle window has passed
        if (!messageTimestamps.containsKey(message) || 
            timestamp - messageTimestamps.get(message) >= THROTTLE_WINDOW) {
            
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        return false;
    }
}
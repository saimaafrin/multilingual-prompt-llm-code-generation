import java.util.HashMap;
import java.util.Map;

class Logger {
    private Map<String, Integer> messageTimestamps;
    
    public Logger() {
        messageTimestamps = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        // If message not seen before or 10 seconds have elapsed since last print
        if (!messageTimestamps.containsKey(message) || 
            timestamp - messageTimestamps.get(message) >= 10) {
            
            messageTimestamps.put(message, timestamp);
            return true;
        }
        return false;
    }
}
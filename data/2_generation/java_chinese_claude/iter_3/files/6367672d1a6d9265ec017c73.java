import java.util.*;

class Logger {
    private Map<String, Integer> messageTimestamps;
    private static final int THROTTLE_SECONDS = 10;
    
    public Logger() {
        messageTimestamps = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        // If message not seen before or last timestamp was more than 10 seconds ago
        if (!messageTimestamps.containsKey(message) || 
            timestamp - messageTimestamps.get(message) >= THROTTLE_SECONDS) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        return false;
    }
}
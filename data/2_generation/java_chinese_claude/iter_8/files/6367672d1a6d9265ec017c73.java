import java.util.*;

class Logger {
    private Map<String, Integer> messageTimestamps;
    private static final int THROTTLE_SECONDS = 10;
    
    public Logger() {
        messageTimestamps = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        // 如果消息不存在或者已经超过10秒
        if (!messageTimestamps.containsKey(message) || 
            timestamp - messageTimestamps.get(message) >= THROTTLE_SECONDS) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        return false;
    }
}
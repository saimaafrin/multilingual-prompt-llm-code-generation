import java.util.*;

class Logger {
    private Map<String, Integer> messageTimestamps;
    private static final int THROTTLE_SECONDS = 10;
    
    public Logger() {
        messageTimestamps = new HashMap<>();
    }
    
    /** 
     * 如果在给定的时间戳下应该打印消息，则返回真，否则返回假。
     * 如果此方法返回假，则消息将不会被打印。时间戳的粒度为秒。
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        // 如果消息不存在或者已经超过10秒限制
        if (!messageTimestamps.containsKey(message) || 
            timestamp - messageTimestamps.get(message) >= THROTTLE_SECONDS) {
            
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        return false;
    }
}
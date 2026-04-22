import java.util.HashMap;
import java.util.Map;

public class Logger {
    private Map<String, Integer> messageTimestamps;

    public Logger() {
        messageTimestamps = new HashMap<>();
    }

    /**
     * 如果在给定的时间戳下应该打印消息，则返回真，否则返回假。如果此方法返回假，则消息将不会被打印。时间戳的粒度为秒。
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (messageTimestamps.containsKey(message)) {
            int lastTimestamp = messageTimestamps.get(message);
            if (timestamp - lastTimestamp >= 10) {
                messageTimestamps.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            messageTimestamps.put(message, timestamp);
            return true;
        }
    }
}
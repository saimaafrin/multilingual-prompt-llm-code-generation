import java.util.HashMap;
import java.util.Map;

public class Logger {
    private Map<String, Integer> messageTimestamps;

    public Logger() {
        messageTimestamps = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed. The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (messageTimestamps.containsKey(message)) {
            int lastTimestamp = messageTimestamps.get(message);
            if (timestamp - lastTimestamp < 10) {
                return false;
            }
        }
        messageTimestamps.put(message, timestamp);
        return true;
    }
}
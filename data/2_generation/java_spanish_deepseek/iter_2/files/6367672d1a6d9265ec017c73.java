import java.util.HashMap;
import java.util.Map;

public class MessageLogger {
    private Map<String, Integer> messageTimestamps;

    public MessageLogger() {
        messageTimestamps = new HashMap<>();
    }

    /**
     * Devuelve "true" si el mensaje debe imprimirse en la tiempo dada, de lo contrario devuelve falso. 
     * Si este método devuelve falso, el mensaje no se imprimirá. El tiempo está en segundos.
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
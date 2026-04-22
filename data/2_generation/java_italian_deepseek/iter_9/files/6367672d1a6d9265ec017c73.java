import java.util.HashMap;
import java.util.Map;

public class Logger {
    private Map<String, Integer> messageTimestamps;

    public Logger() {
        messageTimestamps = new HashMap<>();
    }

    /**
     * Restituisce true se il messaggio deve essere stampato nel timestamp fornito, altrimenti restituisce false.
     * Se questo metodo restituisce false, il messaggio non verrà stampato. Il timestamp è in granularità di secondi.
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
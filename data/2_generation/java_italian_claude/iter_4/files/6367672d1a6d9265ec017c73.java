import java.util.HashMap;
import java.util.Map;

class Logger {
    private Map<String, Integer> messageTimestamps;
    private static final int THROTTLE_SECONDS = 10;
    
    public Logger() {
        messageTimestamps = new HashMap<>();
    }
    
    /**
     * Restituisce true se il messaggio deve essere stampato nel timestamp fornito, altrimenti restituisce false.
     * Se questo metodo restituisce false, il messaggio non verrà stampato.
     * Il timestamp è in granularità di secondi.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamps.containsKey(message)) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        int lastPrinted = messageTimestamps.get(message);
        if (timestamp - lastPrinted >= THROTTLE_SECONDS) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        return false;
    }
}
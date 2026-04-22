import java.util.HashMap;
import java.util.Map;

class Logger {
    private Map<String, Integer> messageTimestamps;
    private static final int THROTTLE_WINDOW = 10; // 10 seconds window
    
    public Logger() {
        messageTimestamps = new HashMap<>();
    }
    
    /**
     * Restituisce true se il messaggio deve essere stampato nel timestamp fornito, 
     * altrimenti restituisce false. Se questo metodo restituisce false, il messaggio 
     * non verrà stampato. Il timestamp è in granularità di secondi.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        // If message has never been seen before or the throttle window has passed
        if (!messageTimestamps.containsKey(message) || 
            timestamp - messageTimestamps.get(message) >= THROTTLE_WINDOW) {
            
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        return false;
    }
}
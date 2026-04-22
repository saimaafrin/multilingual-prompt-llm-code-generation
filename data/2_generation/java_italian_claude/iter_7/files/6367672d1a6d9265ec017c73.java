import java.util.HashMap;
import java.util.Map;

class Logger {
    private Map<String, Integer> messageTimestamps;
    private static final int THROTTLE_WINDOW = 10; // 10 seconds window
    
    public Logger() {
        messageTimestamps = new HashMap<>();
    }
    
    /**
     * Restituisce true se il messaggio deve essere stampato nel timestamp fornito, altrimenti restituisce false.
     * Se questo metodo restituisce false, il messaggio non verrà stampato.
     * Il timestamp è in granularità di secondi.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        // Se il messaggio non è mai stato stampato prima, stampalo
        if (!messageTimestamps.containsKey(message)) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        // Controlla se sono passati almeno 10 secondi dall'ultima stampa
        int lastPrinted = messageTimestamps.get(message);
        if (timestamp - lastPrinted >= THROTTLE_WINDOW) {
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        return false;
    }
}
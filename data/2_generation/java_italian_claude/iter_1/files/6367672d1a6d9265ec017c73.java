import java.util.HashMap;
import java.util.Map;

class Logger {
    private Map<String, Integer> messageTimestamps;
    
    public Logger() {
        messageTimestamps = new HashMap<>();
    }
    
    /**
     * Restituisce true se il messaggio deve essere stampato nel timestamp fornito, 
     * altrimenti restituisce false. Se questo metodo restituisce false, il messaggio 
     * non verrà stampato. Il timestamp è in granularità di secondi.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        // Se il messaggio non è mai stato stampato prima o sono passati 10+ secondi
        // dall'ultima volta che è stato stampato, permettiamo di stamparlo
        if (!messageTimestamps.containsKey(message) || 
            timestamp - messageTimestamps.get(message) >= 10) {
            
            messageTimestamps.put(message, timestamp);
            return true;
        }
        
        return false;
    }
}
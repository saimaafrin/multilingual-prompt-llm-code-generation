import org.atmosphere.cpr.AtmosphereHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AtmosphereHandlerManager {
    private final Map<String, AtmosphereHandler> handlers = new ConcurrentHashMap<>();
    
    public boolean removeAtmosphereHandler(String mapping) {
        if (mapping == null) {
            return false;
        }
        
        AtmosphereHandler removed = handlers.remove(mapping);
        return removed != null;
    }
}
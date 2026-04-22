import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AtmosphereFrameworkImpl extends AtmosphereFramework {
    
    private final Map<String, AtmosphereHandler> handlers = new ConcurrentHashMap<>();

    /** 
     * Remove an {@link AtmosphereHandler}.
     * @param mapping the mapping used when invoking {@link #addAtmosphereHandler(String,AtmosphereHandler)}
     * @return true if removed
     */
    public AtmosphereFramework removeAtmosphereHandler(String mapping) {
        if (mapping == null) {
            return this;
        }

        // Normalize mapping
        if (!mapping.startsWith("/")) {
            mapping = "/" + mapping;
        }

        // Remove the handler
        AtmosphereHandler handler = handlers.remove(mapping);
        
        if (handler != null) {
            // Clean up any associated resources
            handler.destroy();
            
            // Remove any framework-specific mappings
            frameworkConfig().remove(mapping);
        }

        return this;
    }
}
import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;
import org.atmosphere.cpr.AtmosphereConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AtmosphereFrameworkImpl extends AtmosphereFramework {

    private final Map<String, AtmosphereHandler> handlers = new ConcurrentHashMap<>();

    /** 
     * Rimuove un {@link AtmosphereHandler}.
     * @param mapping il mapping utilizzato quando si invoca {@link #addAtmosphereHandler(String,AtmosphereHandler)};
     * @return true se rimosso
     */
    public AtmosphereFramework removeAtmosphereHandler(String mapping) {
        if (mapping == null || mapping.isEmpty()) {
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
            
            // Remove from framework's internal mappings
            frameworkConfig().properties().remove(mapping);
            
            // Remove any associated interceptors
            clearHandlerInterceptors(mapping);
        }

        return this;
    }

    private void clearHandlerInterceptors(String mapping) {
        // Implementation specific cleanup of interceptors
        // This would depend on how interceptors are stored/managed
    }
}
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
            frameworkMappings().remove(mapping);
            
            // Notify listeners if any
            onRemoveAtmosphereHandler(mapping, handler);
        }

        return this;
    }

    // Helper methods
    private Map<String, AtmosphereHandler> frameworkMappings() {
        return handlers;
    }

    private void onRemoveAtmosphereHandler(String mapping, AtmosphereHandler handler) {
        // Implementation for notifying listeners about handler removal
        // This would be implemented based on specific framework requirements
    }
}
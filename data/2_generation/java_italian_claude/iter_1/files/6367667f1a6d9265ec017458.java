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
        String normalizedMapping = mapping.startsWith("/") ? mapping : "/" + mapping;
        
        // Remove handler if exists
        AtmosphereHandler removed = handlers.remove(normalizedMapping);
        
        if (removed != null) {
            // Clean up any associated resources
            removed.destroy();
            
            // Update framework configuration
            AtmosphereConfig config = getAtmosphereConfig();
            if (config != null) {
                config.properties().remove(normalizedMapping);
            }
        }

        return this;
    }
}
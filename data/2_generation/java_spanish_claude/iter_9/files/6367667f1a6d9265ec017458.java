import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;
import org.atmosphere.cpr.AtmosphereConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AtmosphereFrameworkImpl extends AtmosphereFramework {

    private final Map<String, AtmosphereHandler> handlers = new ConcurrentHashMap<>();

    /** 
     * Elimina un {@link AtmosphereHandler}.
     * @param mapping el mapeo utilizado al invocar {@link #addAtmosphereHandler(String,AtmosphereHandler)};
     * @return true si se eliminó
     */
    public AtmosphereFramework removeAtmosphereHandler(String mapping) {
        if (mapping == null) {
            return this;
        }

        String mappingPath = mapping.endsWith("/") ? mapping : mapping + "/";
        
        if (handlers.containsKey(mappingPath)) {
            handlers.remove(mappingPath);
            return this;
        }

        // Try without trailing slash if not found
        if (handlers.containsKey(mapping)) {
            handlers.remove(mapping);
        }

        return this;
    }
}
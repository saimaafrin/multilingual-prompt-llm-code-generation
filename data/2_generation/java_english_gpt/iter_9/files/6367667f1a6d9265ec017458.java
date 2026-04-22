import java.util.HashMap;
import java.util.Map;

public class AtmosphereFramework {
    private Map<String, AtmosphereHandler> handlers = new HashMap<>();

    /**
     * Remove an  {@link AtmosphereHandler}.
     * @param mapping the mapping used when invoking {@link #addAtmosphereHandler(String,AtmosphereHandler)};
     * @return true if removed
     */
    public boolean removeAtmosphereHandler(String mapping) {
        if (handlers.containsKey(mapping)) {
            handlers.remove(mapping);
            return true;
        }
        return false;
    }

    public void addAtmosphereHandler(String mapping, AtmosphereHandler handler) {
        handlers.put(mapping, handler);
    }

    // Dummy AtmosphereHandler class for demonstration purposes
    public static class AtmosphereHandler {
        // Implementation of AtmosphereHandler
    }
}
import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereFramework {
    // Assuming a map to store the handlers
    private java.util.Map<String, AtmosphereHandler> handlers = new java.util.HashMap<>();

    /**
     * Elimina un {@link AtmosphereHandler}.
     * @param mapping el mapeo utilizado al invocar {@link #addAtmosphereHandler(String, AtmosphereHandler)};
     * @return true si se eliminó
     */
    public boolean removeAtmosphereHandler(String mapping) {
        if (handlers.containsKey(mapping)) {
            handlers.remove(mapping);
            return true;
        }
        return false;
    }

    // Assuming this method exists to add handlers
    public void addAtmosphereHandler(String mapping, AtmosphereHandler handler) {
        handlers.put(mapping, handler);
    }
}
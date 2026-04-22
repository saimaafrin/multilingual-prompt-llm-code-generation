import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereFramework {
    private java.util.Map<String, AtmosphereHandler> handlers = new java.util.HashMap<>();

    /**
     * Rimuove un {@link AtmosphereHandler}.
     * @param mapping il mapping utilizzato quando si invoca {@link #addAtmosphereHandler(String, AtmosphereHandler)};
     * @return true se rimosso
     */
    public boolean removeAtmosphereHandler(String mapping) {
        if (handlers.containsKey(mapping)) {
            handlers.remove(mapping);
            return true;
        }
        return false;
    }

    /**
     * Aggiunge un {@link AtmosphereHandler}.
     * @param mapping il mapping associato all'handler
     * @param handler l'handler da aggiungere
     */
    public void addAtmosphereHandler(String mapping, AtmosphereHandler handler) {
        handlers.put(mapping, handler);
    }
}
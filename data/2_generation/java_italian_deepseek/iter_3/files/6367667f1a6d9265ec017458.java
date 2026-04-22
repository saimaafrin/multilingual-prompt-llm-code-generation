import java.util.HashMap;
import java.util.Map;

public class AtmosphereFramework {
    private Map<String, AtmosphereHandler> handlers = new HashMap<>();

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
     * Aggiunge un {@link AtmosphereHandler} con un mapping specifico.
     * @param mapping il mapping da associare all'handler
     * @param handler l'handler da aggiungere
     */
    public void addAtmosphereHandler(String mapping, AtmosphereHandler handler) {
        handlers.put(mapping, handler);
    }

    // Classe AtmosphereHandler di esempio
    public static class AtmosphereHandler {
        // Implementazione dell'handler
    }
}
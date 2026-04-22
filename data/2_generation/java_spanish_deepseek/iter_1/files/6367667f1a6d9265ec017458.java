import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereFramework {
    private Map<String, AtmosphereHandler> handlers = new HashMap<>();

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

    /**
     * Añade un {@link AtmosphereHandler} al framework.
     * @param mapping el mapeo utilizado para identificar el handler.
     * @param handler el {@link AtmosphereHandler} a añadir.
     */
    public void addAtmosphereHandler(String mapping, AtmosphereHandler handler) {
        handlers.put(mapping, handler);
    }

    // Other methods and fields of AtmosphereFramework...
}
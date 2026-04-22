import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereManager {
    private AtmosphereFramework atmosphereFramework;

    public AtmosphereManager() {
        atmosphereFramework = new AtmosphereFramework();
    }

    /** 
     * Rimuove un {@link AtmosphereHandler}.
     * @param mapping il mapping utilizzato quando si invoca {@link #addAtmosphereHandler(String,AtmosphereHandler)};
     * @return true se rimosso
     */
    public boolean removeAtmosphereHandler(String mapping) {
        AtmosphereHandler handler = atmosphereFramework.getAtmosphereHandler(mapping);
        if (handler != null) {
            atmosphereFramework.removeAtmosphereHandler(mapping);
            return true;
        }
        return false;
    }
}
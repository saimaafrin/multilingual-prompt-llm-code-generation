import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereManager {
    private AtmosphereFramework atmosphereFramework;

    public AtmosphereManager() {
        atmosphereFramework = new AtmosphereFramework();
    }

    /** 
     * Remove an  {@link AtmosphereHandler}.
     * @param mapping the mapping used when invoking {@link #addAtmosphereHandler(String,AtmosphereHandler)};
     * @return true if removed
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
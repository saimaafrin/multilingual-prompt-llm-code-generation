import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereHandlerManager {
    private AtmosphereFramework atmosphereFramework;

    public AtmosphereHandlerManager(AtmosphereFramework atmosphereFramework) {
        this.atmosphereFramework = atmosphereFramework;
    }

    /** 
     * Elimina un {@link AtmosphereHandler}.
     * @param mapping el mapeo utilizado al invocar {@link #addAtmosphereHandler(String,AtmosphereHandler)};
     * @return true si se eliminó
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
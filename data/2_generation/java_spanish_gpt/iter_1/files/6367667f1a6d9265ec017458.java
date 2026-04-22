import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereManager {
    private AtmosphereFramework atmosphereFramework;

    public AtmosphereManager() {
        this.atmosphereFramework = new AtmosphereFramework();
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
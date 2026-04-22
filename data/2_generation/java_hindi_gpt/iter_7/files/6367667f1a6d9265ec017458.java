import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereManager {
    private AtmosphereFramework atmosphereFramework;

    public AtmosphereManager() {
        atmosphereFramework = new AtmosphereFramework();
    }

    /**
     * एक {@link AtmosphereHandler} को हटाएं।
     * @param mapping वह मैपिंग है जो {@link #addAtmosphereHandler(String,AtmosphereHandler)} को कॉल करते समय उपयोग की जाती है;
     * @return यदि हटाया गया है तो true
     */
    public AtmosphereFramework removeAtmosphereHandler(String mapping) {
        AtmosphereHandler handler = atmosphereFramework.getAtmosphereHandler(mapping);
        if (handler != null) {
            atmosphereFramework.removeAtmosphereHandler(mapping);
            return atmosphereFramework;
        }
        return null;
    }
}
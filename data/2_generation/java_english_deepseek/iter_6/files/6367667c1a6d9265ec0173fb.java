import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

public class AtmosphereResourceImpl implements AtmosphereResource {

    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        // Assuming this class has a list to store event listeners
        if (e != null) {
            eventListeners.add(e);
        }
        return this;
    }

    // Assuming this class has a list to store event listeners
    private List<AtmosphereResourceEventListener> eventListeners = new ArrayList<>();
}
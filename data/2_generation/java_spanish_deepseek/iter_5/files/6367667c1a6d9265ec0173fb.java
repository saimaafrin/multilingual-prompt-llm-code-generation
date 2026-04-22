import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

public class AtmosphereResourceImpl implements AtmosphereResource {

    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        // Assuming this class has a method to add listeners
        this.listeners.add(e);
        return this;
    }

    // Assuming this class has a list to hold listeners
    private List<AtmosphereResourceEventListener> listeners = new ArrayList<>();
}
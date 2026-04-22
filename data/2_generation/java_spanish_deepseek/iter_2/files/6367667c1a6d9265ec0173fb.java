import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

public class MyAtmosphereResource implements AtmosphereResource {

    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        // Assuming this class has a method to add listeners
        this.listeners.add(e);
        return this;
    }

    // Other necessary methods and fields would be here
    private List<AtmosphereResourceEventListener> listeners = new ArrayList<>();
}
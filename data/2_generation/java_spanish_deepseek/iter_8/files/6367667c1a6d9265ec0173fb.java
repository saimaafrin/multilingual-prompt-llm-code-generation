import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

public class MyAtmosphereResource implements AtmosphereResource {

    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        // Assuming this class has a list to store listeners
        if (e != null) {
            listeners.add(e);
        }
        return this;
    }

    // Assuming this class has a list to store listeners
    private List<AtmosphereResourceEventListener> listeners = new ArrayList<>();
}
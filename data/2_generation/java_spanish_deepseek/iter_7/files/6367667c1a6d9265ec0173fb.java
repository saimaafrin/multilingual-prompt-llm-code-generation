import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

public class MyAtmosphereResource implements AtmosphereResource {

    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        // Assuming this class has a way to store listeners, e.g., a list
        // For example:
        // this.listeners.add(e);
        return this; // Return the current instance for method chaining
    }
}
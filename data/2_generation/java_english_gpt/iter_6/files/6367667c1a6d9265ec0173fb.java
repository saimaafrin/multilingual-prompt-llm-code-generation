import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

public class MyAtmosphereResource extends AtmosphereResource {

    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        // Logic to add the event listener
        // This is a placeholder implementation
        if (e == null) {
            throw new IllegalArgumentException("Event listener cannot be null");
        }
        // Assuming there's a list to hold listeners
        eventListeners.add(e);
        return this;
    }
    
    // Placeholder for the list of event listeners
    private List<AtmosphereResourceEventListener> eventListeners = new ArrayList<>();
}
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

public class MyAtmosphereResource extends AtmosphereResource {

    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        // Logic to add the event listener
        // This is a placeholder for the actual implementation
        // You would typically store the listener in a list or map for later use
        System.out.println("Event listener added: " + e);
        return this; // Returning the current instance for method chaining
    }
}
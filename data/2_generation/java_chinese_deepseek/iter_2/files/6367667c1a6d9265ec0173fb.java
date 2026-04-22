import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

public class AtmosphereResourceImpl implements AtmosphereResource {

    private AtmosphereResourceEventListener eventListener;

    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        this.eventListener = e;
        return this;
    }

    // Other methods of AtmosphereResource interface would be implemented here
}
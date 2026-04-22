import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

public class AtmosphereResourceImpl implements AtmosphereResource {

    private List<AtmosphereResourceEventListener> listeners = new ArrayList<>();

    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        if (e != null) {
            listeners.add(e);
        }
        return this;
    }
}
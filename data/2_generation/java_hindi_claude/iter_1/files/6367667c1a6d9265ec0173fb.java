import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;
import java.util.List;
import java.util.ArrayList;

public class AtmosphereResourceManager {
    private List<AtmosphereResourceEventListener> listeners;
    private AtmosphereResource resource;

    public AtmosphereResourceManager() {
        this.listeners = new ArrayList<>();
    }

    public void addEventListener(AtmosphereResourceEventListener e) {
        if (e != null) {
            listeners.add(e);
            if (resource != null) {
                resource.addEventListener(e);
            }
        }
    }
}
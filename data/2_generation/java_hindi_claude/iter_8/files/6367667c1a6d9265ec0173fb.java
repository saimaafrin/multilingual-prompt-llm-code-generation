import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;
import java.util.List;
import java.util.ArrayList;

public class AtmosphereHandler {
    private List<AtmosphereResourceEventListener> listeners = new ArrayList<>();
    private AtmosphereResource resource;

    public void addEventListener(AtmosphereResourceEventListener e) {
        if (e != null) {
            listeners.add(e);
            if (resource != null) {
                resource.addEventListener(e);
            }
        }
    }
}
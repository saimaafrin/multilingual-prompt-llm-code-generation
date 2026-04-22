import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;
import java.util.List;
import java.util.ArrayList;

public class AtmosphereHandler {
    private List<AtmosphereResourceEventListener> listeners;
    
    public AtmosphereHandler() {
        listeners = new ArrayList<AtmosphereResourceEventListener>();
    }

    public void addEventListener(AtmosphereResourceEventListener e) {
        if (e != null && !listeners.contains(e)) {
            listeners.add(e);
        }
    }
}
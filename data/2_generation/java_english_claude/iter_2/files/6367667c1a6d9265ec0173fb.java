import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;
import java.util.List;
import java.util.ArrayList;

public class AtmosphereResourceImpl implements AtmosphereResource {
    
    private List<AtmosphereResourceEventListener> listeners = new ArrayList<>();
    
    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        if (e != null) {
            listeners.add(e);
        }
        return this;
    }
    
    // Other required interface methods...
}
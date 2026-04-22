import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

public class AtmosphereResourceImpl extends AtmosphereResource {

    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        if (e != null) {
            this.addEventListener(e);
        }
        return this;
    }
}
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

public class MyAtmosphereResource {

    private AtmosphereResource resource;

    public MyAtmosphereResource(AtmosphereResource resource) {
        this.resource = resource;
    }

    /**
     * एक {@link AtmosphereResourceEventListener} जोड़ें।
     * @param e AtmosphereResourceEventListener का एक उदाहरण
     */
    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        if (resource != null) {
            resource.addEventListener(e);
        }
        return resource;
    }
}
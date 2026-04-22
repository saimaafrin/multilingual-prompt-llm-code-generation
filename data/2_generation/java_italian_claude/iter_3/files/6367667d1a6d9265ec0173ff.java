import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Meteor;

public class MeteorLookup {

    /**
     * Recupera un'istanza di {@link Meteor} basata su {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return un {@link Meteor} o null se non trovato
     */
    public static Meteor lookup(HttpServletRequest r) {
        if (r == null) {
            return null;
        }
        
        try {
            // Try to get existing Meteor instance
            Meteor meteor = Meteor.build(r);
            if (meteor != null) {
                return meteor;
            }
            
            // Try to get from AtmosphereResource
            AtmosphereResource resource = (AtmosphereResource) r.getAttribute(AtmosphereResource.ATMOSPHERE_RESOURCE);
            if (resource != null) {
                return Meteor.build(resource.getRequest());
            }
            
            return null;
            
        } catch (Exception e) {
            return null;
        }
    }
}
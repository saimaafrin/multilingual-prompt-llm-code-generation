import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Meteor;
import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Retrieve an instance of {@link Meteor} based on the {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return a {@link Meteor} or null if not found
     */
    public static Meteor lookup(HttpServletRequest r) {
        if (r == null) {
            return null;
        }
        
        // Try to get existing Meteor instance
        Meteor meteor = (Meteor) r.getAttribute(Meteor.class.getName());
        
        if (meteor == null) {
            // Try to get from AtmosphereResource
            AtmosphereResource resource = (AtmosphereResource) 
                r.getAttribute(AtmosphereResource.class.getName());
                
            if (resource != null) {
                meteor = Meteor.build(resource);
            }
        }
        
        return meteor;
    }
}
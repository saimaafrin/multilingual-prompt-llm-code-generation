import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Meteor;
import javax.servlet.http.HttpServletRequest;

public class MeteorRetriever {

    /**
     * Retrieve an instance of {@link Meteor} based on the {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest} 
     * @return a {@link Meteor} or null if not found
     */
    public static Meteor retrieve(HttpServletRequest r) {
        if (r == null) {
            return null;
        }
        
        try {
            // Try to get existing Meteor instance
            Meteor meteor = Meteor.build(r);
            if (meteor != null) {
                return meteor;
            }
            
            // Create new Meteor instance if none exists
            AtmosphereResource resource = (AtmosphereResource) 
                r.getAttribute(AtmosphereResource.ATMOSPHERE_RESOURCE);
                
            if (resource != null) {
                return Meteor.build(resource);
            }
            
            return null;
            
        } catch (Exception e) {
            return null;
        }
    }
}
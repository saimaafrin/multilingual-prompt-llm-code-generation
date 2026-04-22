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
        
        // Try to get existing Meteor instance
        Meteor meteor = Meteor.build(r);
        
        if (meteor == null || meteor.getAtmosphereResource() == null) {
            return null;
        }
        
        AtmosphereResource resource = meteor.getAtmosphereResource();
        if (!resource.getRequest().getMethod().equalsIgnoreCase("GET")) {
            return null;
        }
        
        return meteor;
    }
}
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Meteor;
import javax.servlet.http.HttpServletRequest;

public class MeteorRetriever {

    /**
     * Retrieve an instance of {@link Meteor} based on the {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return a {@link Meteor} or null if not found
     */
    public Meteor retrieveMeteor(HttpServletRequest r) {
        if (r == null) {
            return null;
        }
        
        try {
            return Meteor.build(r);
        } catch (Exception e) {
            // If Meteor cannot be built from request, return null
            return null;
        }
    }
}
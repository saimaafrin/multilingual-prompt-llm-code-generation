import javax.servlet.http.HttpServletRequest;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Meteor;

public class MeteorLookup {

    /**
     * Recupera una instancia de {@link Meteor} basada en el {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return un {@link Meteor} o null si no se encuentra
     */
    public static Meteor lookup(HttpServletRequest r) {
        if (r == null) {
            return null;
        }
        
        try {
            // Intenta obtener el Meteor desde el request
            Meteor meteor = (Meteor) r.getAttribute(Meteor.class.getName());
            
            if (meteor == null) {
                // Si no existe, intenta obtenerlo desde el AtmosphereResource
                AtmosphereResource resource = (AtmosphereResource) 
                    r.getAttribute(AtmosphereResource.class.getName());
                    
                if (resource != null) {
                    meteor = Meteor.build(resource);
                }
            }
            
            return meteor;
            
        } catch (Exception e) {
            return null;
        }
    }
}
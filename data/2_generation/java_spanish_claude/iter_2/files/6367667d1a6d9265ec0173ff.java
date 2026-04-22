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
            Meteor meteor = Meteor.build(r);
            
            if (meteor != null) {
                AtmosphereResource resource = meteor.getAtmosphereResource();
                if (resource != null && !resource.isCancelled()) {
                    return meteor;
                }
            }
            
            // Si no se encuentra un Meteor válido, retorna null
            return null;
            
        } catch (Exception e) {
            // En caso de error retorna null
            return null;
        }
    }
}
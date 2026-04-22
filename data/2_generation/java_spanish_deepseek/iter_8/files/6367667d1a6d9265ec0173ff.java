import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Recupera una instancia de {@link Meteor} basada en el {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return un {@link Meteor} o null si no se encuentra
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Assuming Meteor is stored as an attribute in the request
        Object meteorObj = r.getAttribute("meteor");
        if (meteorObj instanceof Meteor) {
            return (Meteor) meteorObj;
        }
        return null;
    }
}

// Assuming the Meteor class is defined elsewhere
class Meteor {
    // Class implementation here
}
import javax.servlet.http.HttpServletRequest;

public class Meteor {
    // Assuming Meteor class has some properties and methods
}

public class MeteorLookup {

    /**
     * Retrieve an instance of {@link Meteor} based on the {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return a {@link Meteor} or null if not found
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Example implementation: retrieve Meteor from session attribute
        if (r != null) {
            return (Meteor) r.getSession().getAttribute("meteor");
        }
        return null;
    }
}
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
        // Example implementation: retrieve a Meteor instance from the request attributes
        // This is just a placeholder implementation; adjust according to your actual logic
        Object meteorObj = r.getAttribute("meteor");
        if (meteorObj instanceof Meteor) {
            return (Meteor) meteorObj;
        }
        return null;
    }
}
import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Retrieve an instance of {@link Meteor} based on the {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return a {@link Meteor} or null if not found
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Assuming Meteor is a class that can be retrieved from the request attributes
        // or some other mechanism based on the request.
        // This is a placeholder implementation.
        return (Meteor) r.getAttribute("meteor");
    }
}

// Assuming Meteor class is defined elsewhere
class Meteor {
    // Class implementation
}
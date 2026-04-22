import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Retrieve an instance of {@link Meteor} based on the {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return a {@link Meteor} or null if not found
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Assuming Meteor is a class with a constructor or factory method
        // that can be initialized with HttpServletRequest.
        // This is a placeholder implementation.
        // You would replace this with actual logic to retrieve or create a Meteor instance.
        
        // Example: Check if a Meteor instance is stored in the request attributes
        Object meteorObj = r.getAttribute("meteor");
        if (meteorObj instanceof Meteor) {
            return (Meteor) meteorObj;
        }
        
        // If not found, return null
        return null;
    }
}

// Assuming Meteor class is defined elsewhere
class Meteor {
    // Placeholder class for Meteor
}
import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Retrieve an instance of {@link Meteor} based on the {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return a {@link Meteor} or null if not found
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Assuming Meteor is a class with a constructor or factory method
        // that can be initialized with HttpServletRequest data.
        // This is a placeholder implementation.
        
        // Example: Check if a specific attribute is present in the request
        Object meteorAttribute = r.getAttribute("meteor");
        if (meteorAttribute instanceof Meteor) {
            return (Meteor) meteorAttribute;
        }
        
        // If no Meteor instance is found, return null
        return null;
    }
}

// Assuming the Meteor class is defined elsewhere
class Meteor {
    // Placeholder class for Meteor
}
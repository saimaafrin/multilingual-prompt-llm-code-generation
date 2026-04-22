import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    public static Meteor lookup(HttpServletRequest r) {
        // Assuming Meteor is a class that can be retrieved from the request
        // For example, it might be stored as an attribute in the request
        Object meteorObj = r.getAttribute("meteor");

        if (meteorObj instanceof Meteor) {
            return (Meteor) meteorObj;
        }

        // If the attribute is not found or is not an instance of Meteor, return null
        return null;
    }
}

// Assuming the Meteor class is defined elsewhere
class Meteor {
    // Meteor class implementation
}
import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    public static Meteor lookup(HttpServletRequest r) {
        // Assuming Meteor is a class that can be retrieved from the request attributes
        // or session attributes. Adjust the logic based on your actual implementation.
        
        // Check if the Meteor instance is stored in the request attributes
        Meteor meteor = (Meteor) r.getAttribute("meteor");
        if (meteor != null) {
            return meteor;
        }

        // If not found in request attributes, check the session attributes
        meteor = (Meteor) r.getSession().getAttribute("meteor");
        if (meteor != null) {
            return meteor;
        }

        // If still not found, return null
        return null;
    }
}
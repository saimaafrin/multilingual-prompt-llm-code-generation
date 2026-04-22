import javax.servlet.http.HttpServletRequest;

public class Meteor {
    // Assuming Meteor class has some properties and methods
    // For example:
    private String id;
    private String name;

    public Meteor(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Static method to lookup Meteor instance from HttpServletRequest
    public static Meteor lookup(HttpServletRequest r) {
        // Assuming the Meteor instance is stored as an attribute in the request
        Object meteorObj = r.getAttribute("meteor");

        if (meteorObj instanceof Meteor) {
            return (Meteor) meteorObj;
        } else {
            return null;
        }
    }
}
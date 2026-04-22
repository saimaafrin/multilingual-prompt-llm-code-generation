import javax.servlet.http.HttpServletRequest;

public class Meteor {
    // Assuming Meteor is a class with some properties and methods
    // For the sake of this example, we'll keep it simple
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

    public static Meteor lookup(HttpServletRequest r) {
        // Assuming the Meteor instance is stored as an attribute in the request
        // You can modify this logic based on how the Meteor instance is stored
        Object meteorObj = r.getAttribute("meteor");

        if (meteorObj instanceof Meteor) {
            return (Meteor) meteorObj;
        } else {
            return null;
        }
    }
}
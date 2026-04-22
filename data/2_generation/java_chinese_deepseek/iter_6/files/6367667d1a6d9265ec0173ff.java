import javax.servlet.http.HttpServletRequest;

public class Meteor {
    // Assuming Meteor is a class with some properties and methods
    // For example purposes, let's assume it has a constructor and a method
    private String id;

    public Meteor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static Meteor lookup(HttpServletRequest r) {
        // Assuming the Meteor instance is stored in the request attribute with key "meteor"
        Object meteorObj = r.getAttribute("meteor");
        if (meteorObj instanceof Meteor) {
            return (Meteor) meteorObj;
        }
        return null; // Return null if no Meteor instance is found
    }
}
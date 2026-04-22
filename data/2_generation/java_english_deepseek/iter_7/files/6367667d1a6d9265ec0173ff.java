import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Retrieve an instance of {@link Meteor} based on the {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return a {@link Meteor} or null if not found
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Assuming Meteor is a class with a constructor or factory method
        // Here we check for a specific attribute in the request to determine if a Meteor instance exists
        Object meteorObj = r.getAttribute("meteor");
        if (meteorObj instanceof Meteor) {
            return (Meteor) meteorObj;
        }
        return null;
    }
}

class Meteor {
    // Example Meteor class implementation
    private String name;

    public Meteor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
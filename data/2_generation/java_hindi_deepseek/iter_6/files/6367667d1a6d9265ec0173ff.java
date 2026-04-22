import javax.servlet.http.HttpServletRequest;

public class Meteor {
    // Assuming Meteor class has some properties and methods
    // For example purposes, let's assume it has a constructor and a method
    private String name;

    public Meteor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Meteor lookup(HttpServletRequest r) {
        // Extract some information from the HttpServletRequest to determine the Meteor
        // For example, let's assume we are looking for a Meteor based on a request parameter
        String meteorName = r.getParameter("meteorName");

        if (meteorName != null && !meteorName.isEmpty()) {
            return new Meteor(meteorName);
        } else {
            return null;
        }
    }
}
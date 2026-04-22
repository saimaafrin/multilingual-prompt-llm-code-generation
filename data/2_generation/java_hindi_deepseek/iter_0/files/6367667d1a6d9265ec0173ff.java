import javax.servlet.http.HttpServletRequest;

public class Meteor {
    // Assuming Meteor class has some properties and methods
    // For example:
    private String name;
    private int id;

    public Meteor(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static Meteor lookup(HttpServletRequest r) {
        // Example logic to retrieve a Meteor instance based on HttpServletRequest
        // This is a placeholder implementation and should be adjusted based on actual requirements
        String meteorName = r.getParameter("meteorName");
        String meteorIdStr = r.getParameter("meteorId");

        if (meteorName != null && meteorIdStr != null) {
            try {
                int meteorId = Integer.parseInt(meteorIdStr);
                return new Meteor(meteorName, meteorId);
            } catch (NumberFormatException e) {
                // Handle the case where meteorId is not a valid integer
                return null;
            }
        } else {
            return null;
        }
    }
}
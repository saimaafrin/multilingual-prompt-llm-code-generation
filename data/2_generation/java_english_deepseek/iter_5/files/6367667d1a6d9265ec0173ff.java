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
}

public class MeteorLookup {

    /**
     * Retrieve an instance of {@link Meteor} based on the {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return a {@link Meteor} or null if not found
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Example logic to retrieve a Meteor instance based on the request
        // This is a placeholder implementation and should be replaced with actual logic
        String meteorId = r.getParameter("meteorId");
        if (meteorId != null) {
            // Assuming we have a method to fetch Meteor by ID
            return fetchMeteorById(meteorId);
        }
        return null;
    }

    private static Meteor fetchMeteorById(String id) {
        // Placeholder method to simulate fetching a Meteor by ID
        // In a real application, this might involve querying a database or another service
        if ("123".equals(id)) {
            return new Meteor("123", "Sample Meteor");
        }
        return null;
    }
}
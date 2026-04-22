import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Retrieve an instance of  {@link Meteor} based on the {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return a {@link Meteor} or null if not found
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Example implementation, replace with actual logic to retrieve Meteor instance
        String meteorId = r.getParameter("meteorId");
        if (meteorId == null || meteorId.isEmpty()) {
            return null;
        }
        
        // Simulating a database or service call to find a Meteor instance
        Meteor meteor = findMeteorById(meteorId);
        return meteor;
    }

    private static Meteor findMeteorById(String meteorId) {
        // Placeholder for actual logic to find a Meteor by its ID
        // In a real application, this would likely involve querying a database or service
        if ("123".equals(meteorId)) {
            return new Meteor(meteorId, "Example Meteor");
        }
        return null;
    }
}

class Meteor {
    private String id;
    private String name;

    public Meteor(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters can be added here
}
import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /** 
     * Retrieve an instance of  {@link Meteor} based on the {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return a {@link Meteor} or null if not found
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Example logic to retrieve a Meteor instance based on the request
        String meteorId = r.getParameter("meteorId");
        if (meteorId != null) {
            // Simulate a lookup in a database or a collection
            return findMeteorById(meteorId);
        }
        return null;
    }

    private static Meteor findMeteorById(String meteorId) {
        // Placeholder for actual implementation
        // In a real scenario, this would query a database or a data structure
        // For demonstration, we return a new Meteor instance if the ID matches a specific value
        if ("123".equals(meteorId)) {
            return new Meteor(meteorId, "Example Meteor");
        }
        return null;
    }

    // Example Meteor class
    public static class Meteor {
        private String id;
        private String name;

        public Meteor(String id, String name) {
            this.id = id;
            this.name = name;
        }

        // Getters and setters can be added here
    }
}
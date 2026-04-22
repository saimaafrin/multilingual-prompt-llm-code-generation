import javax.servlet.http.HttpServletRequest;

public class Meteor {
    // Assuming Meteor class has some properties and methods
    // For example purposes, let's assume it has a constructor and a method
    private String id;

    public Meteor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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
        // This is a placeholder implementation and should be adapted to your actual use case
        String meteorId = r.getParameter("meteorId");

        if (meteorId != null && !meteorId.isEmpty()) {
            // Assuming the Meteor instance is created based on the meteorId
            return new Meteor(meteorId);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage
        // This is just for demonstration purposes and won't run without a proper HttpServletRequest
        HttpServletRequest request = null; // Replace with actual HttpServletRequest
        Meteor meteor = lookup(request);
        if (meteor != null) {
            System.out.println("Meteor found with ID: " + meteor.getId());
        } else {
            System.out.println("Meteor not found.");
        }
    }
}
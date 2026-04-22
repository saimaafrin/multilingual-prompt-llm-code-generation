import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Recupera un'istanza di {@link Meteor} basata su {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return un {@link Meteor} o null se non trovato
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Assuming Meteor is a class with a constructor or a factory method
        // Here we simulate retrieving a Meteor instance based on the request
        String meteorId = r.getParameter("meteorId");
        if (meteorId != null && !meteorId.isEmpty()) {
            // Simulate fetching a Meteor instance by ID
            return new Meteor(meteorId);
        }
        return null;
    }
}

class Meteor {
    private String id;

    public Meteor(String id) {
        this.id = id;
    }

    // Additional methods and properties for Meteor class
}
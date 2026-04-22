import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Recupera un'istanza di {@link Meteor} basata su {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return un {@link Meteor} o null se non trovato
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Assuming Meteor is a class with a constructor or a factory method
        // Here we simulate the lookup logic based on the request
        String meteorId = r.getParameter("meteorId");
        if (meteorId != null && !meteorId.isEmpty()) {
            // Simulate fetching a Meteor instance based on the ID
            return new Meteor(meteorId);
        }
        return null;
    }

    // Assuming Meteor class is defined as follows
    public static class Meteor {
        private String id;

        public Meteor(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Meteor{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }
}
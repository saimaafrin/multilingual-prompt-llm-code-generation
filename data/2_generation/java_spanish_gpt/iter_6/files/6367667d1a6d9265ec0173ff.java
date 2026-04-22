import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Recupera una instancia de {@link Meteor} basada en el {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return un {@link Meteor} o null si no se encuentra
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Simulación de la lógica para recuperar una instancia de Meteor
        String meteorId = r.getParameter("meteorId");
        
        if (meteorId == null || meteorId.isEmpty()) {
            return null;
        }
        
        // Aquí se debería implementar la lógica para buscar el Meteor en una base de datos o en memoria
        // Por simplicidad, se devuelve una nueva instancia de Meteor si se encuentra un ID válido
        return new Meteor(meteorId);
    }
}

class Meteor {
    private String id;

    public Meteor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
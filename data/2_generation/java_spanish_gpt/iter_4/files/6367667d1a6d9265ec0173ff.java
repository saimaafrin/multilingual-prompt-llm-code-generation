import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Recupera una instancia de {@link Meteor} basada en el {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return un {@link Meteor} o null si no se encuentra
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Simulación de la búsqueda de una instancia de Meteor
        String meteorId = r.getParameter("meteorId");
        
        if (meteorId == null || meteorId.isEmpty()) {
            return null;
        }
        
        // Aquí se debería implementar la lógica para recuperar el Meteor
        // Por simplicidad, se devuelve una nueva instancia de Meteor
        // En un caso real, se buscaría en una base de datos o en otro almacenamiento
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
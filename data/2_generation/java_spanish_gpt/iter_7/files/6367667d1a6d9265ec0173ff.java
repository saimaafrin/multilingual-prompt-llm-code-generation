import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Recupera una instancia de {@link Meteor} basada en el {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return un {@link Meteor} o null si no se encuentra
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Lógica para recuperar la instancia de Meteor
        String meteorId = r.getParameter("meteorId");
        if (meteorId == null || meteorId.isEmpty()) {
            return null;
        }
        
        // Simulación de búsqueda de Meteor en una base de datos o repositorio
        Meteor meteor = findMeteorById(meteorId);
        return meteor;
    }

    private static Meteor findMeteorById(String meteorId) {
        // Aquí se implementaría la lógica para buscar el Meteor en la base de datos
        // Por simplicidad, retornamos un nuevo Meteor si el ID es válido
        if ("validMeteorId".equals(meteorId)) {
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

    public String getId() {
        return id;
    }
}
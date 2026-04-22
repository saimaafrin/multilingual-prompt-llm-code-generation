import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Recupera una instancia de {@link Meteor} basada en el {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return un {@link Meteor} o null si no se encuentra
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Aquí se implementaría la lógica para buscar y retornar una instancia de Meteor
        // basada en el HttpServletRequest. Por ejemplo, se podría buscar en los atributos
        // de la solicitud o en algún otro lugar donde se almacene la instancia de Meteor.
        
        // Ejemplo de implementación:
        Meteor meteor = (Meteor) r.getAttribute("meteor");
        return meteor;
    }
}

class Meteor {
    // Clase Meteor con sus atributos y métodos
}
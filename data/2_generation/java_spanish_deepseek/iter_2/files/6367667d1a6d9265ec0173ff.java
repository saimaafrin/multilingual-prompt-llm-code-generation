import javax.servlet.http.HttpServletRequest;

public class MeteorLookup {

    /**
     * Recupera una instancia de {@link Meteor} basada en el {@link HttpServletRequest}.
     * @param r {@link HttpServletRequest}
     * @return un {@link Meteor} o null si no se encuentra
     */
    public static Meteor lookup(HttpServletRequest r) {
        // Aquí se implementaría la lógica para buscar y retornar una instancia de Meteor
        // basada en el HttpServletRequest. Por ejemplo, se podría buscar en la sesión o en
        // algún atributo de la solicitud.

        // Ejemplo de implementación:
        Meteor meteor = (Meteor) r.getAttribute("meteor");
        if (meteor == null) {
            meteor = (Meteor) r.getSession().getAttribute("meteor");
        }

        return meteor;
    }
}

class Meteor {
    // Implementación de la clase Meteor
}
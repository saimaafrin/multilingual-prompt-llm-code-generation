import java.util.logging.Logger;

public class LoggerChecker {

    /**
     * Verifica si el registrador nombrado existe en la jerarquía. Si es así, devuelve su referencia; de lo contrario, devuelve <code>null</code>.
     * @param name El nombre del registrador que se busca.
     * @return El registrador si existe, o <code>null</code> si no existe.
     */
    public Logger exists(String name) {
        Logger logger = Logger.getLogger(name);
        if (logger != null) {
            return logger;
        } else {
            return null;
        }
    }
}
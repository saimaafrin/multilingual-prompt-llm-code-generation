import java.util.logging.Logger;
import java.util.logging.LogManager;

public class LoggerChecker {

    /**
     * Verifica si el registrador nombrado existe en la jerarquía. Si es así, devuelve su referencia; de lo contrario, devuelve <code>null</code>.
     * @param name El nombre del registrador que se busca.
     * @return El registrador si existe, o <code>null</code> si no existe.
     */
    public Logger exists(String name) {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger(name);
        return logger;
    }
}
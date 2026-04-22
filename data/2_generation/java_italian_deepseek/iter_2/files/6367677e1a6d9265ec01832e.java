import java.util.logging.Logger;

public class LoggerChecker {

    /**
     * Controlla se il logger con il nome specificato esiste nella gerarchia. Se sì, restituisce il suo riferimento, altrimenti restituisce <code>null</code>.
     * @param name Il nome del logger da cercare.
     * @return Il logger se esiste, altrimenti <code>null</code>.
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
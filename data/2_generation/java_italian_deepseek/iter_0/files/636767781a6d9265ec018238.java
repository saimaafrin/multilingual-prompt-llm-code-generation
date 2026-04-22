import java.util.List;

public class Logger {
    private List<Appender> appenders;

    /**
     * Restituisce <code>true</code> se l'appender specificato è presente nell'elenco degli appender allegati, <code>false</code> altrimenti.
     * @param appender L'appender da cercare.
     * @return <code>true</code> se l'appender è presente, <code>false</code> altrimenti.
     * @since 1.2
     */
    public boolean isAttached(Appender appender) {
        return appenders.contains(appender);
    }
}

// Assuming Appender is a class or interface defined elsewhere
interface Appender {
    // Appender methods
}
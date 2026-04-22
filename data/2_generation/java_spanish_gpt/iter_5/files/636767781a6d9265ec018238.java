import java.util.List;

public class AppenderManager {
    private List<Appender> appenders;

    public AppenderManager(List<Appender> appenders) {
        this.appenders = appenders;
    }

    /** 
     * Devuelve <code>true</code> si el "appender" especificado está en la lista de "appenders" adjuntos, <code>false</code> en caso contrario.
     * @since 1.2 
     */
    public boolean isAttached(Appender appender) {
        return appenders.contains(appender);
    }
}

class Appender {
    // Implementation of Appender class
}
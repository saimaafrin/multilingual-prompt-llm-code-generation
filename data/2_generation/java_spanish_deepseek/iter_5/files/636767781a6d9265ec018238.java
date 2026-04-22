import java.util.List;

public class Logger {
    private List<Appender> appenders;

    /**
     * Devuelve <code>true</code> si el "appender" especificado está en la lista de "appenders" adjuntos, <code>false</code> en caso contrario.
     * @param appender El appender que se desea verificar.
     * @return <code>true</code> si el appender está en la lista, <code>false</code> en caso contrario.
     * @since 1.2
     */
    public boolean isAttached(Appender appender) {
        if (appender == null || appenders == null) {
            return false;
        }
        return appenders.contains(appender);
    }
}
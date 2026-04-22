import java.util.ArrayList;
import java.util.List;

public class AppenderManager {
    private List<Appender> appenders;

    public AppenderManager() {
        this.appenders = new ArrayList<>();
    }

    /**
     * Restituisce <code>true</code> se l'appender specificato è presente nell'elenco degli appender allegati, <code>false</code> altrimenti.
     * @since 1.2 
     */
    public boolean isAttached(Appender appender) {
        return appenders.contains(appender);
    }

    public void attachAppender(Appender appender) {
        if (!appenders.contains(appender)) {
            appenders.add(appender);
        }
    }

    public void detachAppender(Appender appender) {
        appenders.remove(appender);
    }
}

class Appender {
    private String name;

    public Appender(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Appender appender = (Appender) obj;
        return name.equals(appender.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
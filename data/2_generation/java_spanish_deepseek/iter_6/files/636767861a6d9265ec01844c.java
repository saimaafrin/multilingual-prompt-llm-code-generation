import java.util.List;
import java.util.Iterator;

public class Logger {
    private List<Appender> appenders;

    public Logger(List<Appender> appenders) {
        this.appenders = appenders;
    }

    /**
     * Elimina el "appender" con el nombre pasado como parámetro de la lista de "appenders".
     */
    public void removeAppender(String name) {
        Iterator<Appender> iterator = appenders.iterator();
        while (iterator.hasNext()) {
            Appender appender = iterator.next();
            if (appender.getName().equals(name)) {
                iterator.remove();
                break; // Assuming names are unique, we can break after removal
            }
        }
    }
}

class Appender {
    private String name;

    public Appender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Appender;

public class Logger {
    private List<Appender> appenders;

    public Logger() {
        appenders = new ArrayList<>();
    }

    /**
     * Rimuove l'appender con il nome passato come parametro dalla lista degli appenders.
     */
    public void removeAppender(String name) {
        if (name == null) {
            return;
        }

        Appender toRemove = null;
        for (Appender appender : appenders) {
            if (name.equals(appender.getName())) {
                toRemove = appender;
                break;
            }
        }

        if (toRemove != null) {
            appenders.remove(toRemove);
            toRemove.close();
        }
    }
}
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Appender;

public class AppenderManager {
    private List<Appender> appenders;

    public AppenderManager() {
        this.appenders = new ArrayList<>();
    }

    /**
     * Remove the appender with the name passed as parameter form the list of appenders.
     * @param name The name of the appender to remove
     * @return The removed appender, or null if not found
     */
    public Appender removeAppender(String name) {
        if (name == null || appenders == null) {
            return null;
        }

        for (int i = 0; i < appenders.size(); i++) {
            Appender appender = appenders.get(i);
            if (appender != null && name.equals(appender.getName())) {
                return appenders.remove(i);
            }
        }
        return null;
    }
}
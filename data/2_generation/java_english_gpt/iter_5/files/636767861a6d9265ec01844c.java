import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppenderManager {
    private List<Appender> appenders;

    public AppenderManager() {
        this.appenders = new ArrayList<>();
    }

    public void removeAppender(String name) {
        Iterator<Appender> iterator = appenders.iterator();
        while (iterator.hasNext()) {
            Appender appender = iterator.next();
            if (appender.getName().equals(name)) {
                iterator.remove();
                break; // Exit after removing the first matching appender
            }
        }
    }

    // Example Appender class for demonstration purposes
    private class Appender {
        private String name;

        public Appender(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
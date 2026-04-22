import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Logger {
    private List<Appender> appenders;

    public Logger() {
        this.appenders = new ArrayList<>();
    }

    /**
     * Remove the appender with the name passed as parameter from the list of appenders.
     */
    public void removeAppender(String name) {
        Iterator<Appender> iterator = appenders.iterator();
        while (iterator.hasNext()) {
            Appender appender = iterator.next();
            if (appender.getName().equals(name)) {
                iterator.remove();
                break; // Assuming appender names are unique, we can break after removal
            }
        }
    }

    // Assuming Appender class has a getName() method
    private static class Appender {
        private String name;

        public Appender(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
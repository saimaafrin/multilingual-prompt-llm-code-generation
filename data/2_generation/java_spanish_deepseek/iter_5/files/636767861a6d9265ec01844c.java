import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Appender> appenders;

    public Logger() {
        this.appenders = new ArrayList<>();
    }

    public void removeAppender(String name) {
        appenders.removeIf(appender -> appender.getName().equals(name));
    }

    // Assuming Appender class exists with a getName() method
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
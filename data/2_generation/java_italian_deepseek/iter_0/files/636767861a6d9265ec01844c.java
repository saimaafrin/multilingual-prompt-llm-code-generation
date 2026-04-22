import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Appender> appenders;

    public Logger() {
        this.appenders = new ArrayList<>();
    }

    /**
     * Rimuove l'appender con il nome passato come parametro dalla lista degli appenders.
     * @param name Il nome dell'appender da rimuovere.
     */
    public void removeAppender(String name) {
        appenders.removeIf(appender -> appender.getName().equals(name));
    }

    // Classe interna per rappresentare un Appender
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
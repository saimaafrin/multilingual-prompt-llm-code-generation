import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Logger {
    private List<Appender> appenders;

    public Logger() {
        this.appenders = new ArrayList<>();
    }

    public void addAppender(Appender appender) {
        this.appenders.add(appender);
    }

    /**
     * 从附加器列表中移除指定名称的附加器。
     */
    public void removeAppender(String name) {
        Iterator<Appender> iterator = appenders.iterator();
        while (iterator.hasNext()) {
            Appender appender = iterator.next();
            if (appender.getName().equals(name)) {
                iterator.remove();
                break;
            }
        }
    }

    // Assuming Appender is a class with a getName() method
    public static class Appender {
        private String name;

        public Appender(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.addAppender(new Appender("ConsoleAppender"));
        logger.addAppender(new Appender("FileAppender"));

        logger.removeAppender("ConsoleAppender");

        // Verify that the appender was removed
        for (Appender appender : logger.appenders) {
            System.out.println(appender.getName());
        }
    }
}
import java.util.ArrayList;
import java.util.List;

class LoggingEvent {
    private String message;

    public LoggingEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

interface Appender {
    void doAppend(LoggingEvent event);
}

class ConsoleAppender implements Appender {
    @Override
    public void doAppend(LoggingEvent event) {
        System.out.println("Appending to console: " + event.getMessage());
    }
}

class FileAppender implements Appender {
    @Override
    public void doAppend(LoggingEvent event) {
        // Simulate appending to a file
        System.out.println("Appending to file: " + event.getMessage());
    }
}

public class Logger {
    private List<Appender> appenders = new ArrayList<>();

    public void addAppender(Appender appender) {
        appenders.add(appender);
    }

    /** 
     * Chiama il metodo <code>doAppend</code> su tutti gli appender collegati.  
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        for (Appender appender : appenders) {
            appender.doAppend(event);
        }
        return appenders.size();
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.addAppender(new ConsoleAppender());
        logger.addAppender(new FileAppender());

        LoggingEvent event = new LoggingEvent("This is a log message.");
        int count = logger.appendLoopOnAppenders(event);
        System.out.println("Number of appenders called: " + count);
    }
}
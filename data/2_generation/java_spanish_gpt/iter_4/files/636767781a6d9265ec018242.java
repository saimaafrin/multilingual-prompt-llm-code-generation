import java.util.List;

public class Logger {
    private List<Appender> appenders;

    public Logger(List<Appender> appenders) {
        this.appenders = appenders;
    }

    /** 
     * Llama al método <code>doAppend</code> en todos los "appenders" adjuntos.  
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int appendCount = 0;
        for (Appender appender : appenders) {
            appender.doAppend(event);
            appendCount++;
        }
        return appendCount;
    }
}

interface Appender {
    void doAppend(LoggingEvent event);
}

class LoggingEvent {
    // Implementation of LoggingEvent
}
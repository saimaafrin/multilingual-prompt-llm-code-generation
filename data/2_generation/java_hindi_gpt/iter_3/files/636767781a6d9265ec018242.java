import java.util.List;

public class Logger {
    private List<Appender> appenders;

    public Logger(List<Appender> appenders) {
        this.appenders = appenders;
    }

    /** 
     * सभी जुड़े हुए अपेंडर्स पर <code>doAppend</code> विधि को कॉल करें।  
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
    // Logging event details
}
import java.util.List;

public class AppenderManager {
    private List<Appender> appenders;

    public AppenderManager(List<Appender> appenders) {
        this.appenders = appenders;
    }

    /** 
     * 对所有附加的附加器调用<code>doAppend</code>方法。  
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int appendCount = 0;
        for (Appender appender : appenders) {
            if (appender != null) {
                appender.doAppend(event);
                appendCount++;
            }
        }
        return appendCount;
    }
}

interface Appender {
    void doAppend(LoggingEvent event);
}

class LoggingEvent {
    // LoggingEvent properties and methods
}
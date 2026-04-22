import org.apache.log4j.Appender;
import org.apache.log4j.spi.LoggingEvent;

public class Logger {
    private Appender[] appenders;

    public Logger(Appender[] appenders) {
        this.appenders = appenders;
    }

    /**
     * सभी जुड़े हुए अपेंडर्स पर <code>doAppend</code> विधि को कॉल करें।
     * 
     * @param event लॉगिंग इवेंट
     * @return कॉल किए गए अपेंडर्स की संख्या
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int count = 0;
        if (appenders != null) {
            for (Appender appender : appenders) {
                if (appender != null) {
                    appender.doAppend(event);
                    count++;
                }
            }
        }
        return count;
    }
}
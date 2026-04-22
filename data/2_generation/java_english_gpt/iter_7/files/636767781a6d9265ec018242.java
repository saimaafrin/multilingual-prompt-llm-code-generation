import org.apache.log4j.Appender;
import org.apache.log4j.spi.LoggingEvent;
import java.util.Enumeration;
import org.apache.log4j.Logger;

public class LoggerAppender {
    private Logger logger;

    public LoggerAppender(Logger logger) {
        this.logger = logger;
    }

    /** 
     * Call the <code>doAppend</code> method on all attached appenders.  
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int appendersCalled = 0;
        Enumeration<Appender> appenders = logger.getAllAppenders();
        
        while (appenders.hasMoreElements()) {
            Appender appender = appenders.nextElement();
            appender.doAppend(event);
            appendersCalled++;
        }
        
        return appendersCalled;
    }
}
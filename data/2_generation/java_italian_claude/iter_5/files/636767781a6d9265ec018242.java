import org.apache.log4j.Appender;
import org.apache.log4j.LoggingEvent;
import org.apache.log4j.spi.AppenderAttachable;
import java.util.Enumeration;

public class Logger implements AppenderAttachable {
    
    private final Vector<Appender> appenders = new Vector<>();

    /**
     * Chiama il metodo <code>doAppend</code> su tutti gli appender collegati.
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int size = 0;
        
        if (appenders != null) {
            Enumeration<Appender> iter = appenders.elements();
            while (iter.hasMoreElements()) {
                Appender appender = iter.nextElement();
                appender.doAppend(event);
                size++;
            }
        }
        
        return size;
    }
}
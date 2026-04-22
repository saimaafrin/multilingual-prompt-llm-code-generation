import org.apache.log4j.Appender;
import org.apache.log4j.LoggingEvent;
import org.apache.log4j.spi.AppenderAttachable;
import java.util.Enumeration;

public class AppenderManager implements AppenderAttachable {
    
    private Vector<Appender> appenders;

    public AppenderManager() {
        appenders = new Vector<Appender>();
    }

    /**
     * Llama al método <code>doAppend</code> en todos los "appenders" adjuntos.
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int size = 0;
        
        if(appenders != null && !appenders.isEmpty()) {
            size = appenders.size();
            for(Enumeration<Appender> enumeration = appenders.elements(); 
                enumeration.hasMoreElements();) {
                    Appender appender = enumeration.nextElement();
                    appender.doAppend(event);
            }
        }
        
        return size;
    }
}
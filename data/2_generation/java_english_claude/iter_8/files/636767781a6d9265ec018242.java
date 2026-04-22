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
     * Call the <code>doAppend</code> method on all attached appenders.  
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int size = 0;
        
        if(appenders != null) {
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
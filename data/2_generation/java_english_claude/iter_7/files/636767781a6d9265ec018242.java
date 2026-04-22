import org.apache.log4j.Appender;
import org.apache.log4j.LoggingEvent;
import org.apache.log4j.spi.AppenderAttachable;
import java.util.Enumeration;

public class AppenderManager implements AppenderAttachable {
    
    private Vector appenderList;

    public AppenderManager() {
        appenderList = new Vector();
    }

    public int appendLoopOnAppenders(LoggingEvent event) {
        int size = 0;
        
        if(appenderList != null && !appenderList.isEmpty()) {
            size = appenderList.size();
            Enumeration enumeration = appenderList.elements();
            while(enumeration.hasMoreElements()) {
                Appender appender = (Appender) enumeration.nextElement();
                appender.doAppend(event);
            }
        }
        
        return size;
    }
}
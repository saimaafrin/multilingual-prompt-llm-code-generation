import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class AppenderManager {
    private CopyOnWriteArrayList<Appender<LoggingEvent>> appenderList = new CopyOnWriteArrayList<>();
    
    public int appendLoopOnAppenders(LoggingEvent event) {
        int numberOfAppenders = 0;
        if(appenderList != null && !appenderList.isEmpty()) {
            Iterator<Appender<LoggingEvent>> iter = appenderList.iterator();
            while(iter.hasNext()) {
                Appender<LoggingEvent> appender = iter.next();
                if(appender != null) {
                    appender.doAppend(event);
                    numberOfAppenders++;
                }
            }
        }
        return numberOfAppenders;
    }
}
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class AppenderHandler {
    
    private CopyOnWriteArrayList<Appender<LoggingEvent>> appenderList = new CopyOnWriteArrayList<>();
    
    /**
     * 对所有附加的附加器调用<code>doAppend</code>方法。
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int size = 0;
        if (event != null) {
            Iterator<Appender<LoggingEvent>> iter = appenderList.iterator();
            while (iter.hasNext()) {
                Appender<LoggingEvent> appender = iter.next();
                if (appender != null) {
                    appender.doAppend(event);
                    size++;
                }
            }
        }
        return size;
    }
}
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.AppenderControl;
import java.util.List;

public class AppenderManager {
    private List<AppenderControl> appenders;
    
    public void callAppendersDoAppend(final LogEvent event) {
        if (appenders != null) {
            for (AppenderControl appender : appenders) {
                appender.callAppender(event);
            }
        }
    }
}
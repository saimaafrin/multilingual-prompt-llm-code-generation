import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.AppenderControl;
import java.util.List;

public class AppenderManager {
    private List<AppenderControl> appenders;
    
    /**
     * Call the doAppend method on all attached appenders.
     */
    public void callAppenders(final LogEvent event) {
        if (appenders != null) {
            for (AppenderControl appender : appenders) {
                appender.callAppender(event);
            }
        }
    }
}
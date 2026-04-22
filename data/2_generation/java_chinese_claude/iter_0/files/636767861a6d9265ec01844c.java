import org.apache.logging.log4j.core.Appender;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Logger {
    
    private Map<String, Appender> appenders = new ConcurrentHashMap<>();
    
    /**
     * 从附加器列表中移除指定名称的附加器。
     */
    public void removeAppender(String name) {
        if (name == null) {
            return;
        }
        
        Appender appender = appenders.remove(name);
        if (appender != null) {
            appender.stop();
        }
    }
}
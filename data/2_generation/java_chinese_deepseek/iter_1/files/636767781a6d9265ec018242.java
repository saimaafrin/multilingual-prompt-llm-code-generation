import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.Appender;

public class Logger {
    private Appender[] appenders;

    public Logger(Appender[] appenders) {
        this.appenders = appenders;
    }

    /**
     * 对所有附加的附加器调用<code>doAppend</code>方法。
     * @param event 日志事件
     * @return 成功调用的附加器数量
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int count = 0;
        if (appenders != null) {
            for (Appender appender : appenders) {
                if (appender != null) {
                    appender.doAppend(event);
                    count++;
                }
            }
        }
        return count;
    }
}
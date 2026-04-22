import java.util.List;

public class AppenderManager {
    private List<Appender> appenders;

    public AppenderManager(List<Appender> appenders) {
        this.appenders = appenders;
    }

    /** 
     * 如果指定的Appender在Appender列表中，则返回<code>true</code>，否则返回<code>false</code>。
     * @since 1.2 
     */
    public boolean isAttached(Appender appender) {
        return appenders.contains(appender);
    }
}

class Appender {
    // Appender class implementation
}
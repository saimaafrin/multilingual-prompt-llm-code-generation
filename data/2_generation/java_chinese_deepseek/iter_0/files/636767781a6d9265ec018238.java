import java.util.List;

public class Logger {
    private List<Appender> appenders;

    /**
     * 如果指定的Appender在Appender列表中，则返回<code>true</code>，否则返回<code>false</code>。
     * @param appender 要检查的Appender
     * @return 如果Appender在列表中则返回true，否则返回false
     * @since 1.2
     */
    public boolean isAttached(Appender appender) {
        if (appender == null || appenders == null) {
            return false;
        }
        return appenders.contains(appender);
    }
}

// Assuming Appender is a class or interface that is already defined
interface Appender {
    // Appender methods
}
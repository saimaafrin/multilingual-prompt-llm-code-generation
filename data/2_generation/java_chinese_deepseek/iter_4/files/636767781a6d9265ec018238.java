import java.util.List;

public class Logger {
    private List<Appender> appenders;

    /**
     * 如果指定的Appender在Appender列表中，则返回<code>true</code>，否则返回<code>false</code>。
     * @param appender 要检查的Appender
     * @return 如果Appender在列表中则返回<code>true</code>，否则返回<code>false</code>
     * @since 1.2
     */
    public boolean isAttached(Appender appender) {
        return appenders.contains(appender);
    }
}

// Assuming Appender is a class or interface defined elsewhere
interface Appender {
    // Appender methods
}
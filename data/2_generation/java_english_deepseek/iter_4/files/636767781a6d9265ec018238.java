import java.util.List;

public class Logger {
    private List<Appender> attachedAppenders;

    /**
     * Returns <code>true</code> if the specified appender is in the list of attached appenders, <code>false</code> otherwise.
     * @param appender the appender to check
     * @return <code>true</code> if the appender is attached, <code>false</code> otherwise
     * @since 1.2
     */
    public boolean isAttached(Appender appender) {
        return attachedAppenders.contains(appender);
    }
}
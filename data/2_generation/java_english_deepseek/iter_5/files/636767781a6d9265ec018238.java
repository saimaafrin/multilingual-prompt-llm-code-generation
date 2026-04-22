import java.util.List;

public class Logger {
    private List<Appender> attachedAppenders;

    /**
     * Returns <code>true</code> if the specified appender is in the list of attached appenders, <code>false</code> otherwise.
     * @param appender The appender to check for attachment.
     * @return <code>true</code> if the appender is attached, <code>false</code> otherwise.
     * @since 1.2
     */
    public boolean isAttached(Appender appender) {
        if (attachedAppenders == null || appender == null) {
            return false;
        }
        return attachedAppenders.contains(appender);
    }
}

// Assuming Appender is a class or interface defined elsewhere
interface Appender {
    // Appender methods
}
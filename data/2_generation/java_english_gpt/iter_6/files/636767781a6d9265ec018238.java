import java.util.List;

public class AppenderManager {
    private List<Appender> attachedAppenders;

    public AppenderManager(List<Appender> attachedAppenders) {
        this.attachedAppenders = attachedAppenders;
    }

    /** 
     * Returns <code>true</code> if the specified appender is in the list of attached appenders, <code>false</code> otherwise.
     * @since 1.2 
     */
    public boolean isAttached(Appender appender) {
        return attachedAppenders.contains(appender);
    }
}

class Appender {
    // Appender class implementation
}
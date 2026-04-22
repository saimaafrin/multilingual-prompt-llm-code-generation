import java.util.List;

public class AppenderManager {
    private List<Appender> attachedAppenders;

    public AppenderManager(List<Appender> attachedAppenders) {
        this.attachedAppenders = attachedAppenders;
    }

    /** 
     * यदि निर्दिष्ट ऐपेंडर संलग्न ऐपेंडरों की सूची में है, तो <code>true</code> लौटाता है, अन्यथा <code>false</code>।
     * @since 1.2 
     */
    public boolean isAttached(Appender appender) {
        return attachedAppenders.contains(appender);
    }
}

class Appender {
    // Appender class implementation
}
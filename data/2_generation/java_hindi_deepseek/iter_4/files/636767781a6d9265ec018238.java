import java.util.List;

public class AppenderManager {
    private List<Appender> attachedAppenders;

    /**
     * यदि निर्दिष्ट ऐपेंडर संलग्न ऐपेंडरों की सूची में है, तो <code>true</code> लौटाता है, अन्यथा <code>false</code>।
     * @since 1.2 
     */
    public boolean isAttached(Appender appender) {
        if (appender == null) {
            return false;
        }
        return attachedAppenders.contains(appender);
    }
}
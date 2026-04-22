import java.util.List;

public class AppenderManager {
    private List<Appender> attachedAppenders;

    /**
     * यदि निर्दिष्ट ऐपेंडर संलग्न ऐपेंडरों की सूची में है, तो <code>true</code> लौटाता है, अन्यथा <code>false</code>।
     * @param appender जांच करने के लिए ऐपेंडर
     * @return <code>true</code> यदि ऐपेंडर संलग्न है, अन्यथा <code>false</code>
     * @since 1.2
     */
    public boolean isAttached(Appender appender) {
        return attachedAppenders.contains(appender);
    }
}
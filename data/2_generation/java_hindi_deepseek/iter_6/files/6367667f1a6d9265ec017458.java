import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereFramework {

    private java.util.Map<String, AtmosphereHandler> handlers = new java.util.HashMap<>();

    /**
     * एक {@link AtmosphereHandler} को हटाएं।
     * @param mapping वह मैपिंग है जो {@link #addAtmosphereHandler(String, AtmosphereHandler)} को कॉल करते समय उपयोग की जाती है;
     * @return यदि हटाया गया है तो true
     */
    public boolean removeAtmosphereHandler(String mapping) {
        if (handlers.containsKey(mapping)) {
            handlers.remove(mapping);
            return true;
        }
        return false;
    }

    /**
     * एक {@link AtmosphereHandler} को जोड़ें।
     * @param mapping वह मैपिंग है जो {@link AtmosphereHandler} को संदर्भित करती है;
     * @param handler वह {@link AtmosphereHandler} है जिसे जोड़ा जाना है।
     */
    public void addAtmosphereHandler(String mapping, AtmosphereHandler handler) {
        handlers.put(mapping, handler);
    }
}
import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereFramework {

    private java.util.Map<String, AtmosphereHandler> handlers = new java.util.HashMap<>();

    /**
     * एक {@link AtmosphereHandler} को हटाएं।
     * @param mapping वह मैपिंग है जो {@link #addAtmosphereHandler(String, AtmosphereHandler)} को कॉल करते समय उपयोग की जाती है;
     * @return यदि हटाया गया है तो true
     */
    public AtmosphereFramework removeAtmosphereHandler(String mapping) {
        if (handlers.containsKey(mapping)) {
            handlers.remove(mapping);
            return this;
        }
        return null;
    }

    /**
     * एक {@link AtmosphereHandler} को जोड़ें।
     * @param mapping मैपिंग जिसके लिए हैण्डलर जोड़ा जाएगा।
     * @param handler जोड़ा जाने वाला हैण्डलर।
     */
    public void addAtmosphereHandler(String mapping, AtmosphereHandler handler) {
        handlers.put(mapping, handler);
    }
}
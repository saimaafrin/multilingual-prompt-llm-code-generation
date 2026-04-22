import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;
import org.atmosphere.cpr.AtmosphereResource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AtmosphereFrameworkImpl extends AtmosphereFramework {

    private final Map<String, AtmosphereHandler> handlers = new ConcurrentHashMap<>();

    /**
     * 移除一个 {@link AtmosphereHandler}。
     * @param mapping 在调用 {@link #addAtmosphereHandler(String,AtmosphereHandler)} 时使用的映射；
     * @return 如果成功移除则返回真
     */
    public AtmosphereFramework removeAtmosphereHandler(String mapping) {
        if (mapping == null || mapping.isEmpty()) {
            return this;
        }

        // Normalize mapping
        String normalizedMapping = mapping.startsWith("/") ? mapping : "/" + mapping;
        
        // Remove the handler
        AtmosphereHandler removed = handlers.remove(normalizedMapping);
        
        // Clean up any associated resources
        if (removed != null) {
            // Notify any registered listeners about handler removal
            notifyHandlerRemoval(normalizedMapping, removed);
            
            // Remove any associated resources
            cleanupHandler(removed);
        }

        return this;
    }

    private void notifyHandlerRemoval(String mapping, AtmosphereHandler handler) {
        // Implementation for notification logic
    }

    private void cleanupHandler(AtmosphereHandler handler) {
        // Implementation for cleanup logic
    }
}
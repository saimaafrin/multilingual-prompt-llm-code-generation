import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereManager {
    private AtmosphereFramework atmosphereFramework;

    public AtmosphereManager() {
        this.atmosphereFramework = new AtmosphereFramework();
    }

    /**
     * 移除一个 {@link AtmosphereHandler}。
     * @param mapping 在调用 {@link #addAtmosphereHandler(String,AtmosphereHandler)} 时使用的映射；
     * @return 如果成功移除则返回真
     */
    public AtmosphereFramework removeAtmosphereHandler(String mapping) {
        if (mapping == null || mapping.isEmpty()) {
            return atmosphereFramework;
        }
        
        // Assuming there's a method to remove the handler by mapping
        boolean removed = atmosphereFramework.removeAtmosphereHandler(mapping);
        return removed ? atmosphereFramework : null;
    }
}
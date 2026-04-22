import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereManager {
    private AtmosphereFramework atmosphereFramework;

    public AtmosphereManager() {
        atmosphereFramework = new AtmosphereFramework();
    }

    /**
     * 移除一个 {@link AtmosphereHandler}。
     * @param mapping 在调用 {@link #addAtmosphereHandler(String,AtmosphereHandler)} 时使用的映射；
     * @return 如果成功移除则返回真
     */
    public AtmosphereFramework removeAtmosphereHandler(String mapping) {
        if (atmosphereFramework.getAtmosphereHandlers().containsKey(mapping)) {
            atmosphereFramework.removeAtmosphereHandler(mapping);
            return atmosphereFramework;
        }
        return null; // or throw an exception based on your design choice
    }
}
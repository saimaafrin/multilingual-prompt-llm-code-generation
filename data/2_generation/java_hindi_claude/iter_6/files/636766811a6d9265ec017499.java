import java.util.List;
import org.atmosphere.cpr.AtmosphereInterceptor;

public class InterceptorChecker {

    public static boolean containsInterceptor(List<AtmosphereInterceptor> interceptorList, Class<? extends AtmosphereInterceptor> c) {
        if (interceptorList == null || c == null) {
            return false;
        }
        
        for (AtmosphereInterceptor interceptor : interceptorList) {
            if (c.isInstance(interceptor)) {
                return false;
            }
        }
        return true;
    }
}
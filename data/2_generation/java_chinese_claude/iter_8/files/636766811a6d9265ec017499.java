import org.atmosphere.cpr.AtmosphereInterceptor;
import java.util.List;

public class InterceptorChecker {

    /**
     * <p>检查指定列表中是否至少存在一个给定的 {@link AtmosphereInterceptor 拦截器} 实现类的实例。</p>
     * @param interceptorList 拦截器列表
     * @param c               拦截器类
     * @return 如果列表中已经存在该类的实例，则返回 {@code false}，否则返回 {@code true}
     */
    private boolean checkDuplicate(final List<AtmosphereInterceptor> interceptorList, Class<? extends AtmosphereInterceptor> c) {
        if (interceptorList == null || interceptorList.isEmpty() || c == null) {
            return true;
        }
        
        for (AtmosphereInterceptor interceptor : interceptorList) {
            if (c.isInstance(interceptor)) {
                return false;
            }
        }
        return true;
    }
}
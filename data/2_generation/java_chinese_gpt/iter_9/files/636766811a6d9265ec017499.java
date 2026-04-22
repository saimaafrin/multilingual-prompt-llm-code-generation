import java.util.List;

public class InterceptorChecker {

    /** 
     * <p>检查指定列表中是否至少存在一个给定的 {@link AtmosphereInterceptor 拦截器} 实现类的实例。</p>
     * @param interceptorList 拦截器列表
     * @param c               拦截器类
     * @return 如果列表中已经存在该类的实例，则返回 {@code false}，否则返回 {@code true}
     */
    private boolean checkDuplicate(final List<AtmosphereInterceptor> interceptorList, Class<? extends AtmosphereInterceptor> c) {
        for (AtmosphereInterceptor interceptor : interceptorList) {
            if (c.isInstance(interceptor)) {
                return false; // 已经存在该类的实例
            }
        }
        return true; // 不存在该类的实例
    }
    
    // Assuming AtmosphereInterceptor is defined somewhere
    public interface AtmosphereInterceptor {
        // Interface methods
    }
}
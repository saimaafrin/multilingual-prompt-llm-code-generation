import java.util.List;

public class InterceptorChecker {

    /** 
     * <p> Checks in the specified list if there is at least one instance of the given {@link AtmosphereInterceptor interceptor} implementation class.</p>
     * @param interceptorList the interceptors
     * @param c               the interceptor class
     * @return {@code false} if an instance of the class already exists in the list, {@code true} otherwise
     */
    private boolean checkDuplicate(final List<AtmosphereInterceptor> interceptorList, Class<? extends AtmosphereInterceptor> c) {
        for (AtmosphereInterceptor interceptor : interceptorList) {
            if (c.isInstance(interceptor)) {
                return false; // An instance of the class already exists
            }
        }
        return true; // No instance of the class exists
    }
    
    // Assuming AtmosphereInterceptor is defined somewhere
    public interface AtmosphereInterceptor {
        // Interface methods
    }
}
import java.util.List;

public class AtmosphereInterceptorChecker {

    /**
     * <p> Checks in the specified list if there is at least one instance of the given {@link AtmosphereInterceptor interceptor} implementation class.</p>
     * @param interceptorList the interceptors
     * @param c              the interceptor class
     * @return {@code false} if an instance of the class already exists in the list, {@code true} otherwise
     */
    private boolean checkDuplicate(final List<AtmosphereInterceptor> interceptorList, Class<? extends AtmosphereInterceptor> c) {
        if (interceptorList == null || c == null) {
            return false;
        }
        
        for (AtmosphereInterceptor interceptor : interceptorList) {
            if (c.isAssignableFrom(interceptor.getClass())) {
                return false;
            }
        }
        return true;
    }
}

interface AtmosphereInterceptor {
    // Interface definition needed for compilation
}
import java.util.List;

public class InterceptorChecker {

    /** 
     * <p> निर्दिष्ट सूची में यह जांचता है कि क्या दिए गए {@link AtmosphereInterceptor इंटरसेप्टर} कार्यान्वयन वर्ग का कम से कम एक उदाहरण मौजूद है।</p>
     * @param interceptorList इंटरसेप्टर्स की सूची
     * @param c               इंटरसेप्टर वर्ग
     * @return {@code false} यदि सूची में पहले से ही वर्ग का एक उदाहरण मौजूद है, {@code true} अन्यथा
     */
    private boolean checkDuplicate(final List<AtmosphereInterceptor> interceptorList, Class<? extends AtmosphereInterceptor> c) {
        for (AtmosphereInterceptor interceptor : interceptorList) {
            if (c.isInstance(interceptor)) {
                return false; // Class instance already exists in the list
            }
        }
        return true; // No instance of the class found in the list
    }
    
    // Assuming AtmosphereInterceptor is defined somewhere in your codebase
    public static class AtmosphereInterceptor {
        // Implementation of AtmosphereInterceptor
    }
}
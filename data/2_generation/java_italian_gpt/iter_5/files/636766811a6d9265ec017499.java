import java.util.List;

public class InterceptorChecker {

    /** 
     * <p> Controlla nella lista specificata se esiste almeno un'istanza della data classe di implementazione {@link AtmosphereInterceptor interceptor}. </p>
     * @param interceptorList gli interceptor
     * @param c               la classe dell'interceptor
     * @return {@code false} se un'istanza della classe esiste già nella lista, {@code true} altrimenti
     */
    private boolean checkDuplicate(final List<AtmosphereInterceptor> interceptorList, Class<? extends AtmosphereInterceptor> c) {
        for (AtmosphereInterceptor interceptor : interceptorList) {
            if (interceptor.getClass().equals(c)) {
                return false;
            }
        }
        return true;
    }
    
    // Assuming AtmosphereInterceptor is defined somewhere in your codebase
    public static abstract class AtmosphereInterceptor {
        // Implementation details for AtmosphereInterceptor
    }
}
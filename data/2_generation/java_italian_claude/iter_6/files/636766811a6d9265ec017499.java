import org.atmosphere.cpr.AtmosphereInterceptor;
import java.util.List;

public class InterceptorChecker {
    
    /** 
     * <p> Controlla nella lista specificata se esiste almeno un'istanza della data classe di implementazione {@link AtmosphereInterceptor interceptor}. </p>
     * @param interceptorList gli interceptor
     * @param c               la classe dell'interceptor
     * @return {@code false} se un'istanza della classe esiste già nella lista, {@code true} altrimenti
     */
    private boolean checkDuplicate(final List<AtmosphereInterceptor> interceptorList, Class<? extends AtmosphereInterceptor> c) {
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
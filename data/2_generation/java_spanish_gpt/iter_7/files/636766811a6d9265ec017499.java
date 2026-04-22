import java.util.List;

public class InterceptorChecker {

    /** 
     * <p> Verifica en la lista especificada si hay al menos una instancia de la clase de implementación del {@link AtmosphereInterceptor interceptor} dado.</p>
     * @param interceptorList los interceptores
     * @param c               la clase del interceptor
     * @return {@code false} si ya existe una instancia de la clase en la lista, {@code true} en caso contrario
     */
    private boolean checkDuplicate(final List<AtmosphereInterceptor> interceptorList, Class<? extends AtmosphereInterceptor> c) {
        for (AtmosphereInterceptor interceptor : interceptorList) {
            if (c.isInstance(interceptor)) {
                return false;
            }
        }
        return true;
    }
}

class AtmosphereInterceptor {
    // Implementación de la clase AtmosphereInterceptor
}
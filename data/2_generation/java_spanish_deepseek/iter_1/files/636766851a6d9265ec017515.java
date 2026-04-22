import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Action;

public class AtmosphereResourceInspector {

    /**
     * Suspende automáticamente el {@link AtmosphereResource} basado en el valor de {@link AtmosphereResource.TRANSPORT}.
     * @param r un {@link AtmosphereResource}
     * @return {@link Action#CONTINUE}
     */
    @Override
    public Action inspect(AtmosphereResource r) {
        // Implementación para suspender el recurso basado en el transporte
        if (r.transport() == AtmosphereResource.TRANSPORT.WEBSOCKET) {
            r.suspend();
        } else if (r.transport() == AtmosphereResource.TRANSPORT.LONG_POLLING) {
            r.suspend(-1); // Suspender indefinidamente
        } else {
            // Otros transportes no requieren suspensión
        }
        return Action.CONTINUE;
    }
}
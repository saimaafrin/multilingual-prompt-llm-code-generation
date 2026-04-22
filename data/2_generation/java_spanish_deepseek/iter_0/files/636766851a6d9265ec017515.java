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
        // Obtener el transporte del recurso
        AtmosphereResource.TRANSPORT transport = r.transport();

        // Lógica para suspender el recurso basado en el transporte
        if (transport == AtmosphereResource.TRANSPORT.WEBSOCKET) {
            // Suspender el recurso si el transporte es WEBSOCKET
            r.suspend();
        } else if (transport == AtmosphereResource.TRANSPORT.LONG_POLLING) {
            // Suspender el recurso si el transporte es LONG_POLLING
            r.suspend();
        } else {
            // No suspender el recurso para otros transportes
            // Continuar con el procesamiento normal
        }

        // Retornar CONTINUE para indicar que el procesamiento debe continuar
        return Action.CONTINUE;
    }
}
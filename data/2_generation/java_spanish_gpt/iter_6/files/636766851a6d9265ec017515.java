import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Action;

public class MyAtmosphereResourceInspector {

    /**
     * Suspende automáticamente el {@link AtmosphereResource} basado en el valor de {@link AtmosphereResource.TRANSPORT}.
     * @param r un {@link AtmosphereResource}
     * @return {@link Action#CONTINUE}
     */
    @Override
    public Action inspect(AtmosphereResource r) {
        // Aquí se puede agregar la lógica para suspender el recurso basado en el transporte
        // Por ejemplo, si el transporte es HTTP, se puede suspender el recurso
        if (r.transport() == AtmosphereResource.TRANSPORT.WEBSOCKET) {
            r.suspend();
        }
        return Action.CONTINUE;
    }
}
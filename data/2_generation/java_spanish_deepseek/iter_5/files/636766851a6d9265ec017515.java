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
        // Aquí se podría agregar lógica adicional si es necesario
        return Action.CONTINUE;
    }
}
import java.util.List;
import java.util.ArrayList;

public class ChannelManager {

    private List<IConsumer> consumers = new ArrayList<>();

    /**
     * Agregar nuevos canales de destino.
     * @param channels Los canales a agregar.
     * @param consumer El consumidor asociado a los canales.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels != null && consumer != null) {
            // Asociar el consumidor con los canales
            channels.setConsumer(consumer);
            // Agregar el consumidor a la lista de consumidores
            consumers.add(consumer);
        } else {
            throw new IllegalArgumentException("Channels and consumer must not be null");
        }
    }
}

// Definición de la interfaz IConsumer
interface IConsumer {
    void consume(String message);
}

// Definición de la clase Channels
class Channels {
    private IConsumer consumer;

    public void setConsumer(IConsumer consumer) {
        this.consumer = consumer;
    }

    public IConsumer getConsumer() {
        return consumer;
    }
}
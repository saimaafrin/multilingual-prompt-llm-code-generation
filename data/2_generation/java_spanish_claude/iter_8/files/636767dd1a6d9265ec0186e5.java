import java.util.List;
import java.util.ArrayList;

public class ChannelManager {
    private List<Channels> channelsList;
    private List<IConsumer> consumersList;

    public ChannelManager() {
        this.channelsList = new ArrayList<>();
        this.consumersList = new ArrayList<>();
    }

    /**
     * Agregar nuevos canales de destino.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels != null && consumer != null) {
            channelsList.add(channels);
            consumersList.add(consumer);
        }
    }
}

// Interfaces necesarias para la implementación
interface Channels {
    // Métodos de la interfaz Channels
}

interface IConsumer {
    // Métodos de la interfaz IConsumer
}
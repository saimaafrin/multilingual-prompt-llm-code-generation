import java.util.ArrayList;
import java.util.List;

public class ChannelManager {
    private List<Channels> targetChannels;

    public ChannelManager() {
        this.targetChannels = new ArrayList<>();
    }

    /** 
     * Agregar nuevos canales de destino.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels != null && consumer != null) {
            targetChannels.add(channels);
            consumer.consume(channels);
        }
    }
}

interface IConsumer {
    void consume(Channels channels);
}

class Channels {
    private String name;

    public Channels(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
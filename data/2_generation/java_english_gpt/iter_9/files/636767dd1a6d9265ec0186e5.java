import java.util.ArrayList;
import java.util.List;

public class ChannelManager {
    private List<Channels> targetChannels;

    public ChannelManager() {
        this.targetChannels = new ArrayList<>();
    }

    /** 
     * Add a new target channels.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels != null && consumer != null) {
            targetChannels.add(channels);
            consumer.consume(channels);
        }
    }
}

interface Channels {
    // Define methods for Channels interface
}

interface IConsumer {
    void consume(Channels channels);
}
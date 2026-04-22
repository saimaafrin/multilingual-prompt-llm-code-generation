import java.util.List;
import java.util.ArrayList;

public class ChannelManager {
    private List<Channels> targetChannels;
    private List<IConsumer> consumers;

    public ChannelManager() {
        targetChannels = new ArrayList<>();
        consumers = new ArrayList<>();
    }

    /**
     * Add a new target channels.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels != null && consumer != null) {
            targetChannels.add(channels);
            consumers.add(consumer);
        }
    }
}
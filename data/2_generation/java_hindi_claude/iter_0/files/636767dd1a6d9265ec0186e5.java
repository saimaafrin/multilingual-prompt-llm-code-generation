import java.util.ArrayList;
import java.util.List;

public class ChannelManager {
    private List<String> targetChannels;

    public ChannelManager() {
        this.targetChannels = new ArrayList<>();
    }

    /**
     * Add a new target channels.
     * @param channel The channel name to add
     */
    public void addTargetChannel(String channel) {
        if (channel != null && !channel.isEmpty()) {
            targetChannels.add(channel);
        }
    }
}
import java.util.ArrayList;
import java.util.List;

public class ChannelManager {
    private List<String> targetChannels;

    public ChannelManager() {
        this.targetChannels = new ArrayList<>();
    }

    /**
     * Add a new target channels.
     * @param channel The channel to add
     */
    public void addTargetChannel(String channel) {
        if (channel != null && !channel.isEmpty()) {
            targetChannels.add(channel);
        }
    }

    /**
     * Add multiple new target channels.
     * @param channels List of channels to add
     */
    public void addTargetChannels(List<String> channels) {
        if (channels != null) {
            for (String channel : channels) {
                addTargetChannel(channel);
            }
        }
    }
}
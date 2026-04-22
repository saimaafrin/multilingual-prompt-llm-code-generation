import java.util.List;

public class Channels {
    private List<String> targetChannels;

    public Channels() {
        this.targetChannels = new java.util.ArrayList<>();
    }

    public void addTargetChannel(String channel) {
        targetChannels.add(channel);
    }

    public List<String> getTargetChannels() {
        return targetChannels;
    }
}

public interface IConsumer {
    void consume(String message);
}

public class TargetChannelManager {

    /**
     * Add a new target channels.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        // Assuming the consumer is responsible for handling the new target channels
        for (String channel : channels.getTargetChannels()) {
            consumer.consume("New target channel added: " + channel);
        }
    }
}
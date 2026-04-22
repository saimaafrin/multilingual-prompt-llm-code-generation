import java.util.List;

public class Channels {
    private List<String> channels;

    public Channels(List<String> channels) {
        this.channels = channels;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }
}

public interface IConsumer {
    void consume(String message);
}

public class TargetManager {

    /**
     * Add a new target channels.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels == null || consumer == null) {
            throw new IllegalArgumentException("Channels and consumer must not be null");
        }

        for (String channel : channels.getChannels()) {
            // Simulate adding the channel to the consumer
            consumer.consume("Added channel: " + channel);
        }
    }
}
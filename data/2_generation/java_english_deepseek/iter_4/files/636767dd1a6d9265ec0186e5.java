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
    void consume(String channel);
}

public class TargetAdder {

    /**
     * Add a new target channels.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels == null || consumer == null) {
            throw new IllegalArgumentException("Channels and consumer must not be null");
        }

        for (String channel : channels.getChannels()) {
            consumer.consume(channel);
        }
    }
}
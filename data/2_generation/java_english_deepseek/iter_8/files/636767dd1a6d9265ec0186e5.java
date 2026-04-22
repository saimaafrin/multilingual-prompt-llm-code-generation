import java.util.List;

public class Channels {
    private List<String> channels;

    public Channels(List<String> channels) {
        this.channels = channels;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void addChannel(String channel) {
        channels.add(channel);
    }
}

public interface IConsumer {
    void consume(String message);
}

public class TargetAdder {

    /**
     * Add a new target channels.
     * @param channels The channels to which the new target will be added.
     * @param consumer The consumer that will handle the new target.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        // Assuming the new target is a string message
        String newTarget = "New Target Channel";
        channels.addChannel(newTarget);
        consumer.consume("Added new target: " + newTarget);
    }
}
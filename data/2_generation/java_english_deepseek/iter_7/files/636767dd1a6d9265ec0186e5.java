import java.util.List;

// Assuming Channels and IConsumer are defined as follows:
// Channels is a class that contains a list of channels
// IConsumer is an interface with a method to consume a channel

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
    void consume(String channel);
}

public class TargetAdder {

    /**
     * Add a new target channels.
     * @param channels The Channels object containing the list of channels.
     * @param consumer The IConsumer object that will consume the new channel.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        // Assuming we want to add a new channel named "NewChannel"
        String newChannel = "NewChannel";
        channels.addChannel(newChannel);

        // Notify the consumer about the new channel
        consumer.consume(newChannel);
    }
}
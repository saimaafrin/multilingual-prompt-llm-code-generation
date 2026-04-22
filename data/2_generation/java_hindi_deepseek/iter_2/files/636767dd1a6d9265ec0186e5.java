import java.util.List;

// Assuming Channels and IConsumer are defined as follows:
// Channels is a class that contains a list of channels
// IConsumer is an interface with a method to consume a channel

public class Channels {
    private List<String> channels;

    public Channels() {
        this.channels = new ArrayList<>();
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
     * नए लक्ष्य चैनल जोड़ें।
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        // Assuming we want to add a new channel named "NewTargetChannel"
        String newChannel = "NewTargetChannel";
        channels.addChannel(newChannel);

        // Notify the consumer about the new channel
        consumer.consume(newChannel);
    }
}
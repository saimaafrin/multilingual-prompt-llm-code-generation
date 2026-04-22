import java.util.List;

interface IConsumer {
    void consume(String message);
}

class Channels {
    private List<String> channels;

    public Channels(List<String> channels) {
        this.channels = channels;
    }

    public void addChannel(String channel) {
        channels.add(channel);
    }

    public List<String> getChannels() {
        return channels;
    }
}

public class TargetChannelAdder {
    /**
     * नए लक्ष्य चैनल जोड़ें।
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        // Assuming we want to add a new channel named "NewTargetChannel"
        String newChannel = "NewTargetChannel";
        channels.addChannel(newChannel);

        // Notify the consumer about the new channel
        consumer.consume("New channel added: " + newChannel);
    }
}
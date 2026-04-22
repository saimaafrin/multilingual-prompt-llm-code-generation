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

public class TargetChannelAdder {

    /**
     * नए लक्ष्य चैनल जोड़ें।
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        // Assuming we want to add a new channel named "NewTargetChannel"
        String newChannel = "NewTargetChannel";
        channels.addTargetChannel(newChannel);

        // Notify the consumer about the new channel
        consumer.consume("New target channel added: " + newChannel);
    }
}
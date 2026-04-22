import java.util.ArrayList;
import java.util.List;

class Channels {
    private List<String> targetChannels;

    public Channels() {
        this.targetChannels = new ArrayList<>();
    }

    public void addChannel(String channel) {
        targetChannels.add(channel);
    }

    public List<String> getTargetChannels() {
        return targetChannels;
    }
}

interface IConsumer {
    void consume(String channel);
}

public class ChannelManager {
    private Channels channels;
    private IConsumer consumer;

    public ChannelManager(Channels channels, IConsumer consumer) {
        this.channels = channels;
        this.consumer = consumer;
    }

    /** 
     * Add a new target channels.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        // Example of adding a new channel
        String newChannel = "NewChannel"; // This could be parameterized
        channels.addChannel(newChannel);
        consumer.consume(newChannel);
    }

    public static void main(String[] args) {
        Channels channels = new Channels();
        IConsumer consumer = channel -> System.out.println("Consuming channel: " + channel);
        ChannelManager manager = new ChannelManager(channels, consumer);
        
        manager.addNewTarget(channels, consumer);
        System.out.println("Current target channels: " + channels.getTargetChannels());
    }
}
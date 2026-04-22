import java.util.ArrayList;
import java.util.List;

class Channels {
    private List<String> channelList;

    public Channels() {
        this.channelList = new ArrayList<>();
    }

    public void addChannel(String channel) {
        channelList.add(channel);
    }

    public List<String> getChannels() {
        return channelList;
    }
}

interface IConsumer {
    void consume(String channel);
}

public class TargetManager {
    private Channels channels;
    private IConsumer consumer;

    public TargetManager(Channels channels, IConsumer consumer) {
        this.channels = channels;
        this.consumer = consumer;
    }

    /** 
     * Add a new target channels.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        // Example of adding a new channel
        String newChannel = "New Channel";
        channels.addChannel(newChannel);
        
        // Consume the new channel
        consumer.consume(newChannel);
    }

    public static void main(String[] args) {
        Channels channels = new Channels();
        IConsumer consumer = new IConsumer() {
            @Override
            public void consume(String channel) {
                System.out.println("Consuming channel: " + channel);
            }
        };

        TargetManager targetManager = new TargetManager(channels, consumer);
        targetManager.addNewTarget(channels, consumer);
    }
}
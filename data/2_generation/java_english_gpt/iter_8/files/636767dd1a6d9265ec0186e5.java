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

    public ChannelManager(Channels channels) {
        this.channels = channels;
    }

    /** 
     * Add a new target channels.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        for (String channel : channels.getTargetChannels()) {
            consumer.consume(channel);
        }
    }

    public static void main(String[] args) {
        Channels channels = new Channels();
        channels.addChannel("Channel1");
        channels.addChannel("Channel2");

        IConsumer consumer = new IConsumer() {
            @Override
            public void consume(String channel) {
                System.out.println("Consuming: " + channel);
            }
        };

        ChannelManager manager = new ChannelManager(channels);
        manager.addNewTarget(channels, consumer);
    }
}
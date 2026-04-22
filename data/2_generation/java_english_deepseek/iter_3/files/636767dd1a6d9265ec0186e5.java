import java.util.List;

// Assuming Channels and IConsumer are defined as follows:
interface IConsumer {
    void consume(String message);
}

class Channels {
    private List<IConsumer> consumers;

    public Channels() {
        this.consumers = new ArrayList<>();
    }

    public void addConsumer(IConsumer consumer) {
        this.consumers.add(consumer);
    }

    public List<IConsumer> getConsumers() {
        return this.consumers;
    }
}

public class ChannelManager {

    /**
     * Add a new target channels.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels == null || consumer == null) {
            throw new IllegalArgumentException("Channels and consumer must not be null");
        }
        channels.addConsumer(consumer);
    }
}
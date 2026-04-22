import java.util.List;

public class Channels {
    private List<IConsumer> consumers;

    public Channels() {
        this.consumers = new ArrayList<>();
    }

    public void addConsumer(IConsumer consumer) {
        consumers.add(consumer);
    }

    public List<IConsumer> getConsumers() {
        return consumers;
    }
}

public interface IConsumer {
    void consume(String message);
}

public class TargetAdder {

    /**
     * Add a new target channels.
     * @param channels The channels to which the consumer will be added.
     * @param consumer The consumer to be added to the channels.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels != null && consumer != null) {
            channels.addConsumer(consumer);
        } else {
            throw new IllegalArgumentException("Channels and consumer must not be null");
        }
    }
}
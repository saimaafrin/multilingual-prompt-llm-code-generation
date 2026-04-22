import java.util.List;

public class Channels {
    private List<IConsumer> consumers;

    public Channels() {
        this.consumers = new java.util.ArrayList<>();
    }

    public void addConsumer(IConsumer consumer) {
        this.consumers.add(consumer);
    }

    public List<IConsumer> getConsumers() {
        return this.consumers;
    }
}

public interface IConsumer {
    void consume(String message);
}

public class TargetManager {

    /**
     * Aggiungi un nuovo canale di destinazione.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels != null && consumer != null) {
            channels.addConsumer(consumer);
        } else {
            throw new IllegalArgumentException("Channels and consumer must not be null");
        }
    }
}
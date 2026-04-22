import java.util.List;

interface IConsumer {
    void consume(String message);
}

class Channels {
    private List<IConsumer> consumers;

    public Channels() {
        this.consumers = new java.util.ArrayList<>();
    }

    public void addConsumer(IConsumer consumer) {
        consumers.add(consumer);
    }

    public void notifyConsumers(String message) {
        for (IConsumer consumer : consumers) {
            consumer.consume(message);
        }
    }
}

public class TargetChannelAdder {

    /**
     * नए लक्ष्य चैनल जोड़ें।
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels != null && consumer != null) {
            channels.addConsumer(consumer);
            channels.notifyConsumers("New target channel added: " + consumer.getClass().getSimpleName());
        } else {
            System.out.println("Invalid channels or consumer provided.");
        }
    }

    public static void main(String[] args) {
        Channels channels = new Channels();
        IConsumer consumer = new IConsumer() {
            @Override
            public void consume(String message) {
                System.out.println("Consumer received: " + message);
            }
        };

        TargetChannelAdder adder = new TargetChannelAdder();
        adder.addNewTarget(channels, consumer);
    }
}
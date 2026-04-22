import java.util.List;
import java.util.ArrayList;

public class Channels {
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

public interface IConsumer {
    void consume(String message);
}

public class TargetChannelManager {

    /**
     * 添加新的目标通道。
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels != null && consumer != null) {
            channels.addConsumer(consumer);
        }
    }
}
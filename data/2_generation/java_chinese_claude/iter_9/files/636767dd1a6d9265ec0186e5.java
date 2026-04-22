import java.util.List;
import java.util.ArrayList;

public class ChannelManager {
    private List<Channels> channelsList;
    private List<IConsumer> consumerList;

    public ChannelManager() {
        channelsList = new ArrayList<>();
        consumerList = new ArrayList<>();
    }

    /**
     * 添加新的目标通道。
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels != null && consumer != null) {
            channelsList.add(channels);
            consumerList.add(consumer);
        }
    }
}

// Required interfaces/classes for compilation
interface IConsumer {
    void consume();
}

enum Channels {
    CHANNEL1,
    CHANNEL2,
    CHANNEL3
}
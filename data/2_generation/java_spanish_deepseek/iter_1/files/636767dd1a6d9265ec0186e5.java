import java.util.List;

public class Channels {
    private List<String> channels;

    public Channels(List<String> channels) {
        this.channels = channels;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }
}

public interface IConsumer {
    void consume(String channel);
}

public class ChannelManager {

    /**
     * Agregar nuevos canales de destino.
     */
    public void addNewTarget(Channels channels, IConsumer consumer) {
        List<String> channelList = channels.getChannels();
        for (String channel : channelList) {
            consumer.consume(channel);
        }
    }
}
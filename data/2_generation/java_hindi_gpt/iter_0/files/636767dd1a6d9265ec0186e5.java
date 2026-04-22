import java.util.List;

public class ChannelManager {
    
    public void addNewTarget(Channels channels, IConsumer consumer) {
        if (channels == null || consumer == null) {
            throw new IllegalArgumentException("Channels and consumer cannot be null");
        }
        
        List<Channel> channelList = channels.getChannelList();
        Channel newChannel = new Channel(consumer);
        channelList.add(newChannel);
        
        channels.setChannelList(channelList);
    }
}

class Channels {
    private List<Channel> channelList;

    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }
}

class Channel {
    private IConsumer consumer;

    public Channel(IConsumer consumer) {
        this.consumer = consumer;
    }

    // Additional methods for Channel can be added here
}

interface IConsumer {
    // Define methods for IConsumer
}
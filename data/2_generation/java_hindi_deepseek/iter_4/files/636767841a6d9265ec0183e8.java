import org.apache.log4j.spi.LoggingEvent;

public class EventBuffer {
    private LoggingEvent lastEvent;

    /**
     * एक <code>event</code> को बफर में अंतिम घटना के रूप में जोड़ें।
     * @param event जोड़ने के लिए LoggingEvent
     */
    public void add(LoggingEvent event) {
        this.lastEvent = event;
    }

    public LoggingEvent getLastEvent() {
        return lastEvent;
    }
}
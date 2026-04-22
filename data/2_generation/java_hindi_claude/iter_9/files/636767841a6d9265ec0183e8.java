import java.util.ArrayList;
import java.util.List;

public class EventBuffer {
    private List<Event> events;
    private static final int MAX_BUFFER_SIZE = 100;

    public EventBuffer() {
        events = new ArrayList<>();
    }

    /**
     * Add an <code>event</code> as the last event in the buffer.
     * @param event The event to add to the buffer
     */
    public void addEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }

        if (events.size() >= MAX_BUFFER_SIZE) {
            events.remove(0); // Remove oldest event if buffer is full
        }
        
        events.add(event);
    }
}

// Event class for reference
class Event {
    // Event implementation details
}
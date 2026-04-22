import org.apache.log4j.spi.LoggingEvent;

public class EventBuffer {
    private LoggingEvent[] buffer;
    private int size;
    private int capacity;

    public EventBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LoggingEvent[capacity];
        this.size = 0;
    }

    /**
     * Aggiunge un <code>evento</code> come ultimo evento nel buffer.
     */
    public void add(LoggingEvent event) {
        if (size < capacity) {
            buffer[size] = event;
            size++;
        } else {
            // Se il buffer è pieno, sovrascrive il primo elemento (FIFO)
            for (int i = 1; i < capacity; i++) {
                buffer[i - 1] = buffer[i];
            }
            buffer[capacity - 1] = event;
        }
    }

    // Metodo per ottenere il buffer (opzionale)
    public LoggingEvent[] getBuffer() {
        return buffer;
    }
}
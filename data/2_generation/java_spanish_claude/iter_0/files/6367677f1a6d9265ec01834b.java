import org.apache.log4j.spi.LoggingEvent;

public class CircularBuffer {
    private LoggingEvent[] buffer;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    private int maxSize;

    public CircularBuffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LoggingEvent[maxSize];
    }

    /**
     * Coloca un {@link LoggingEvent} en el búfer. Si el búfer está lleno, el evento es 
     * <b>silenciosamente descartado</b>. Es responsabilidad del llamador asegurarse de 
     * que el búfer tenga espacio libre.
     */
    public void put(LoggingEvent o) {
        if (size < maxSize) {
            buffer[tail] = o;
            tail = (tail + 1) % maxSize;
            size++;
        }
        // Si el buffer está lleno, el evento se descarta silenciosamente
    }
}
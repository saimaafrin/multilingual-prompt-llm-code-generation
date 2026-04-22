import org.apache.log4j.spi.LoggingEvent;

public class LogBuffer {
    private LoggingEvent[] buffer;
    private int size;
    private int currentIndex;
    
    public LogBuffer(int bufferSize) {
        this.buffer = new LoggingEvent[bufferSize];
        this.size = bufferSize;
        this.currentIndex = 0;
    }

    /**
     * Coloca un {@link LoggingEvent} en el búfer. Si el búfer está lleno, el evento es 
     * <b>silenciosamente descartado</b>. Es responsabilidad del llamador asegurarse de 
     * que el búfer tenga espacio libre.
     */
    public void put(LoggingEvent o) {
        if (currentIndex < size) {
            buffer[currentIndex] = o;
            currentIndex++;
        }
        // Si el buffer está lleno, el evento se descarta silenciosamente
    }
}
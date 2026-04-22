import java.util.LinkedList;

public class LoggingBuffer {
    private LinkedList<LoggingEvent> buffer;
    private int capacity;

    public LoggingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    /** 
     * Coloca un {@link LoggingEvent} en el búfer. Si el búfer está lleno, el evento es <b>silenciosamente descartado</b>. Es responsabilidad del llamador asegurarse de que el búfer tenga espacio libre.  
     */
    public void put(LoggingEvent o) {
        if (buffer.size() < capacity) {
            buffer.add(o);
        }
        // Si el búfer está lleno, el evento es descartado silenciosamente.
    }
}

class LoggingEvent {
    // Implementación de LoggingEvent
}
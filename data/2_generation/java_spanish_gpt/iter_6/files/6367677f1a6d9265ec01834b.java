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
        // Si el búfer está lleno, el evento es descartado silenciosamente
    }

    // Clase interna para representar un evento de registro
    public static class LoggingEvent {
        private String message;

        public LoggingEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
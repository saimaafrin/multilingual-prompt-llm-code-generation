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
     * Agrega un <code>evento</code> como el último evento en el búfer.
     */
    public void add(LoggingEvent event) {
        if (size < capacity) {
            buffer[size] = event;
            size++;
        } else {
            // Si el búfer está lleno, se puede manejar de diferentes maneras, como:
            // 1. Ignorar el nuevo evento
            // 2. Sobrescribir el evento más antiguo
            // 3. Expandir el búfer dinámicamente
            // Aquí se implementa la opción 2: sobrescribir el evento más antiguo
            System.arraycopy(buffer, 1, buffer, 0, size - 1);
            buffer[size - 1] = event;
        }
    }

    // Método para obtener el tamaño actual del búfer
    public int size() {
        return size;
    }

    // Método para obtener el evento en una posición específica
    public LoggingEvent get(int index) {
        if (index >= 0 && index < size) {
            return buffer[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }
}
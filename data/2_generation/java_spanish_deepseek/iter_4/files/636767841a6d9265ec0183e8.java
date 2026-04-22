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
            // Si el búfer está lleno, se puede manejar de diferentes maneras, como sobrescribir el primer evento.
            // Aquí simplemente no se agrega el evento.
            System.out.println("Buffer is full. Event not added.");
        }
    }

    // Método para obtener el tamaño actual del búfer
    public int getSize() {
        return size;
    }

    // Método para obtener la capacidad del búfer
    public int getCapacity() {
        return capacity;
    }

    // Método para obtener un evento específico del búfer
    public LoggingEvent getEvent(int index) {
        if (index >= 0 && index < size) {
            return buffer[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}
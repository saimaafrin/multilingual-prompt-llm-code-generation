import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    private Queue<Object> queue;

    public Cola() {
        this.queue = new LinkedList<>();
    }

    /** 
     * Devuelve una representación textual de la cola.
     * @return una representación textual de la cola.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cola: [");
        for (Object item : queue) {
            sb.append(item.toString()).append(", ");
        }
        if (!queue.isEmpty()) {
            sb.setLength(sb.length() - 2); // Eliminar la última coma y espacio
        }
        sb.append("]");
        return sb.toString();
    }

    public void enqueue(Object item) {
        queue.add(item);
    }

    public Object dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.enqueue("Elemento 1");
        cola.enqueue("Elemento 2");
        System.out.println(cola.toString()); // Cola: [Elemento 1, Elemento 2]
        cola.dequeue();
        System.out.println(cola.toString()); // Cola: [Elemento 2]
    }
}
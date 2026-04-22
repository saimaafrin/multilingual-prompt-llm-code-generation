import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> elements;

    public Queue() {
        elements = new LinkedList<>();
    }

    /**
     * Restituisce una rappresentazione testuale della coda.
     * @return una rappresentazione testuale della coda.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        for (int i = 0; i < elements.size(); i++) {
            sb.append(elements.get(i));
            if (i < elements.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void enqueue(T element) {
        elements.addLast(element);
    }

    public T dequeue() {
        return elements.removeFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
}
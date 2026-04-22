import java.util.*;

public class Queue<T> {
    private LinkedList<T> elements;

    public Queue() {
        elements = new LinkedList<>();
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

    /**
     * Restituisce una rappresentazione testuale della coda.
     * @return una rappresentazione testuale della coda.
     */
    @Override
    public String toString() {
        return elements.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.toString()); // Output: [1, 2, 3]
    }
}
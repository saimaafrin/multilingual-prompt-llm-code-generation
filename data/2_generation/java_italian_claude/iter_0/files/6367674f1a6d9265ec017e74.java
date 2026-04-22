import java.util.NoSuchElementException;

public class Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
            this.next = null;
        }
    }

    /**
     * Restituisce una rappresentazione testuale della coda.
     * @return una rappresentazione testuale della coda.
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        Node<E> current = front;
        while (current != null) {
            sb.append(current.element);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        
        sb.append("]");
        return sb.toString();
    }
}
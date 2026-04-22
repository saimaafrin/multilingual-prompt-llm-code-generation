public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Restituisce una rappresentazione testuale della coda.
     * @return una rappresentazione testuale della coda.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = front;
        sb.append("Queue: [");
        while (current != null) {
            sb.append(current.data);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Additional methods for the Queue class (enqueue, dequeue, etc.) can be added here
}
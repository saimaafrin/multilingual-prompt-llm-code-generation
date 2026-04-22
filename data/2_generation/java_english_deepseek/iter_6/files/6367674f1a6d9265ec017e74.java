import java.util.*;

public class QueueToString {
    private Queue<Object> queue;

    public QueueToString() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(Object item) {
        queue.add(item);
    }

    public Object dequeue() {
        return queue.poll();
    }

    /**
     * Returns a textual representation of the queue.
     * @return a textual representation of the queue.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object item : queue) {
            sb.append(item);
            sb.append(", ");
        }
        if (!queue.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove the last ", "
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueToString q = new QueueToString();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.toString()); // Output: [1, 2, 3]
    }
}
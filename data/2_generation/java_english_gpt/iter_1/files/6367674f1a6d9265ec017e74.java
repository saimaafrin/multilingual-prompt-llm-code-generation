import java.util.LinkedList;
import java.util.Queue;

public class QueueRepresentation {
    private Queue<Object> queue;

    public QueueRepresentation() {
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        for (Object item : queue) {
            sb.append(item.toString()).append(", ");
        }
        if (!queue.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove the last comma and space
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        QueueRepresentation q = new QueueRepresentation();
        q.enqueue("First");
        q.enqueue("Second");
        q.enqueue("Third");
        System.out.println(q.toString()); // Output: Queue: [First, Second, Third]
    }
}
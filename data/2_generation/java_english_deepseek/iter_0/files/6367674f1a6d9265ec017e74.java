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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object item : queue) {
            sb.append(item);
            sb.append(", ");
        }
        if (!queue.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length()); // Remove the trailing ", "
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
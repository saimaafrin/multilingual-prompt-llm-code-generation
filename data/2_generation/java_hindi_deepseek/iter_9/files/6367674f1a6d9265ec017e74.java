import java.util.*;

public class QueueToString {
    private Queue<Object> queue;

    public QueueToString() {
        queue = new LinkedList<>();
    }

    public void enqueue(Object item) {
        queue.add(item);
    }

    public Object dequeue() {
        return queue.poll();
    }

    /**
     * कतार का पाठ्य प्रतिनिधित्व लौटाता है।
     * @return कतार का पाठ्य प्रतिनिधित्व।
     */
    @Override
    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {
        QueueToString q = new QueueToString();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        System.out.println(q.toString()); // Output: [A, B, C]
    }
}
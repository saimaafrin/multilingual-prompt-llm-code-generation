import java.util.LinkedList;

public class QueueRepresentation {
    private LinkedList<Object> queue;

    public QueueRepresentation() {
        queue = new LinkedList<>();
    }

    /** 
     * कतार का पाठ्य प्रतिनिधित्व लौटाता है।
     * @return कतार का पाठ्य प्रतिनिधित्व।
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        for (int i = 0; i < queue.size(); i++) {
            sb.append(queue.get(i));
            if (i < queue.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void enqueue(Object item) {
        queue.addLast(item);
    }

    public Object dequeue() {
        return queue.isEmpty() ? null : queue.removeFirst();
    }

    public static void main(String[] args) {
        QueueRepresentation queue = new QueueRepresentation();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.toString()); // Output: Queue: [1, 2, 3]
        queue.dequeue();
        System.out.println(queue.toString()); // Output: Queue: [2, 3]
    }
}
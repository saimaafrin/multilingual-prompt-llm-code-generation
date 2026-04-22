import java.util.LinkedList;

public class QueueRepresentation {
    private LinkedList<Object> queue;

    public QueueRepresentation() {
        queue = new LinkedList<>();
    }

    public void enqueue(Object item) {
        queue.addLast(item);
    }

    public Object dequeue() {
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /** 
     * कतार का पाठ्य प्रतिनिधित्व लौटाता है।
     * @return कतार का पाठ्य प्रतिनिधित्व।
     */
    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {
        QueueRepresentation queue = new QueueRepresentation();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        System.out.println(queue.toString()); // Output: [First, Second, Third]
    }
}
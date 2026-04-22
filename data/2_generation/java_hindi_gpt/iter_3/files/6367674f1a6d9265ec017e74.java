import java.util.LinkedList;

public class Queue {
    private LinkedList<Object> elements;

    public Queue() {
        elements = new LinkedList<>();
    }

    /** 
     * कतार का पाठ्य प्रतिनिधित्व लौटाता है।
     * @return कतार का पाठ्य प्रतिनिधित्व।
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

    // Additional methods to add and remove elements from the queue
    public void enqueue(Object item) {
        elements.addLast(item);
    }

    public Object dequeue() {
        if (!elements.isEmpty()) {
            return elements.removeFirst();
        }
        return null; // or throw an exception
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
}
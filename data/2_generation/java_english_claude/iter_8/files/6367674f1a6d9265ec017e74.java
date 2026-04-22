import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> queue;
    
    public Queue() {
        queue = new LinkedList<>();
    }

    /**
     * Returns a textual representation of the queue.
     * @return a textual representation of the queue.
     */
    public String toString() {
        if (queue.isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for (T element : queue) {
            sb.append(element);
            sb.append(", ");
        }
        
        // Remove trailing comma and space
        sb.setLength(sb.length() - 2);
        sb.append("]");
        
        return sb.toString();
    }
}
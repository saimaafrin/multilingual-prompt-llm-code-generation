import java.util.LinkedList;
import java.util.Queue;

public class QueuePrinter {
    private Queue<Object> queue;
    
    public QueuePrinter() {
        this.queue = new LinkedList<>();
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
        
        for (Object element : queue) {
            sb.append(element);
            sb.append(", ");
        }
        
        // Remove last ", " and close bracket
        sb.setLength(sb.length() - 2);
        sb.append("]");
        
        return sb.toString();
    }
}
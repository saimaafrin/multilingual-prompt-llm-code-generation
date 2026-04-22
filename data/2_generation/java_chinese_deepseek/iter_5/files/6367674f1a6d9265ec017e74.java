import java.util.Queue;

public class QueueToString {
    private Queue<?> queue;

    public QueueToString(Queue<?> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        if (queue == null) {
            return "null";
        }
        if (queue.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object element : queue) {
            sb.append(element).append(", ");
        }
        // Remove the trailing comma and space
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
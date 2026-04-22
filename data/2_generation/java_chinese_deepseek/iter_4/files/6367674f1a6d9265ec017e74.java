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
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object element : queue) {
            sb.append(element);
            sb.append(", ");
        }
        if (!queue.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove the trailing ", "
        }
        sb.append("]");
        return sb.toString();
    }
}
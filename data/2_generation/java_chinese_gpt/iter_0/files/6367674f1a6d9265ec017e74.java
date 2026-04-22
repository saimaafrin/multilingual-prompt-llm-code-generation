import java.util.LinkedList;
import java.util.Queue;

public class QueueToString {
    private Queue<Object> queue;

    public QueueToString() {
        this.queue = new LinkedList<>();
    }

    /**
     * 返回队列的文本表示。
     * @return 队列的文本表示。
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object item : queue) {
            sb.append(item.toString()).append(", ");
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2); // Remove the last comma and space
        }
        sb.append("]");
        return sb.toString();
    }

    public void enqueue(Object item) {
        queue.add(item);
    }

    public Object dequeue() {
        return queue.poll();
    }

    public static void main(String[] args) {
        QueueToString queueToString = new QueueToString();
        queueToString.enqueue("First");
        queueToString.enqueue("Second");
        queueToString.enqueue("Third");
        System.out.println(queueToString.toString()); // Output: [First, Second, Third]
    }
}
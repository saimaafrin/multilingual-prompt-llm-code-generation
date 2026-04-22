import java.util.LinkedList;
import java.util.Queue;

public class QueueToString {
    private Queue<String> queue;

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
        for (String item : queue) {
            sb.append(item).append(", ");
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2); // Remove the last comma and space
        }
        sb.append("]");
        return sb.toString();
    }

    public void enqueue(String item) {
        queue.add(item);
    }

    public String dequeue() {
        return queue.poll();
    }

    public static void main(String[] args) {
        QueueToString queueToString = new QueueToString();
        queueToString.enqueue("first");
        queueToString.enqueue("second");
        queueToString.enqueue("third");
        System.out.println(queueToString.toString()); // Output: [first, second, third]
    }
}
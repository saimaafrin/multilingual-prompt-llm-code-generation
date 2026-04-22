import java.util.Queue;

public class QueueToString {
    private Queue<?> queue;

    public QueueToString(Queue<?> queue) {
        this.queue = queue;
    }

    /**
     * 返回队列的文本表示。
     * @return 队列的文本表示。
     */
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
        // 删除最后一个逗号和空格
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
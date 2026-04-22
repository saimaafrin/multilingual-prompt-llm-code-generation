import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> elements;
    
    public Queue() {
        elements = new LinkedList<>();
    }

    /**
     * 返回队列的文本表示。
     * @return 队列的文本表示。
     */
    public String toString() {
        if (elements.isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for (T element : elements) {
            sb.append(element);
            sb.append(", ");
        }
        
        // Remove last ", " and close bracket
        sb.setLength(sb.length() - 2);
        sb.append("]");
        
        return sb.toString();
    }
}
import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> elements;
    
    public Queue() {
        elements = new LinkedList<>();
    }

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
        
        // Remove last comma and space
        sb.setLength(sb.length() - 2);
        sb.append("]");
        
        return sb.toString();
    }
}
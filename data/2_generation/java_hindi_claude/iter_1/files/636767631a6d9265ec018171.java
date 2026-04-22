import java.util.Objects;

public class LinkedList<T> {
    
    private class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> head;
    
    /**
     * Remove the non null {@code node} from the list.
     * @param node The node to remove
     */
    public void remove(Node<T> node) {
        // Check that node is not null
        Objects.requireNonNull(node);
        
        // If node is head, update head to next node
        if (node == head) {
            head = head.next;
            return;
        }
        
        // Find the node before the one to remove
        Node<T> current = head;
        while (current != null && current.next != node) {
            current = current.next;
        }
        
        // If node was found in list, update next pointer to skip it
        if (current != null) {
            current.next = node.next;
        }
    }
}
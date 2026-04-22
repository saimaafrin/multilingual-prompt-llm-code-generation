import java.util.Objects;

/**
 * Represents a node in a doubly-linked list.
 * @param <E> the type of element stored in the node
 */
public class ListNode<E> {
    private E element;
    private ListNode<E> next;
    private ListNode<E> previous;

    /**
     * Constructs a new ListNode with the specified element.
     * @param element the element to be stored in the node
     */
    public ListNode(E element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    /**
     * Returns the previous node in the list.
     * @return the previous node, or null if this is the first node
     */
    @Override
    public ListNode<E> previousNode() {
        return this.previous;
    }

    /**
     * Sets the previous node for this node.
     * @param previous the node to set as the previous node
     */
    public void setPrevious(ListNode<E> previous) {
        this.previous = previous;
    }

    /**
     * Gets the element stored in this node.
     * @return the element
     */
    public E getElement() {
        return element;
    }

    /**
     * Sets the element stored in this node.
     * @param element the element to set
     */
    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Checks if this node is equal to another object.
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) o;
        return Objects.equals(element, listNode.element);
    }

    /**
     * Generates a hash code for this node.
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(element);
    }

    /**
     * Returns a string representation of the node.
     * @return a string containing the node's element
     */
    @Override
    public String toString() {
        return "ListNode{" +
                "element=" + element +
                '}';
    }
}
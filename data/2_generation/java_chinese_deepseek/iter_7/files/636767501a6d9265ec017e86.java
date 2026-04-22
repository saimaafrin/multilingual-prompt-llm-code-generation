import java.util.List;

/**
 * Returns the previous node in the list.
 * 
 * @return the previous node in the list, or null if there is no previous node.
 */
@Override
public ListNode<E> previousNode() {
    if (this.prev == null) {
        return null;
    }
    return this.prev;
}
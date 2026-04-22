import java.util.List;

/**
 * {@inheritDoc}
 */
@Override
public ListNode<E> previousNode() {
    if (this.prev == null) {
        throw new NoSuchElementException("No previous node available.");
    }
    return this.prev;
}
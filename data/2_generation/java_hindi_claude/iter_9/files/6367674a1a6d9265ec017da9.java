import java.util.concurrent.atomic.AtomicReference;

public class LinkedList<T> {
    private ListNode<T> head;
    private final Object lock = new Object();

    public void moveAllNodes(LinkedList<T> list) {
        synchronized (lock) {
            synchronized (list.lock) {
                if (list.head == null) {
                    return;
                }

                // Get the first and last nodes of the source list
                ListNode<T> firstNode = list.head;
                ListNode<T> lastNode = firstNode;
                while (lastNode.next != null) {
                    lastNode = lastNode.next;
                }

                // Connect the source list to the end of this list
                if (head == null) {
                    head = firstNode;
                } else {
                    ListNode<T> current = head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = firstNode;
                }

                // Clear the source list
                list.head = null;
            }
        }
    }

    // Supporting classes and methods
    private static class ListNode<T> {
        T data;
        ListNode<T> next;

        ListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addListNode(ListNode<T> node) {
        synchronized (lock) {
            if (head == null) {
                head = node;
            } else {
                ListNode<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
            }
            node.next = null;
        }
    }

    public ListNode<T> removeListNode(ListNode<T> node) {
        synchronized (lock) {
            if (head == null) {
                return null;
            }

            if (head == node) {
                head = head.next;
                node.next = null;
                return node;
            }

            ListNode<T> current = head;
            while (current.next != null && current.next != node) {
                current = current.next;
            }

            if (current.next == node) {
                current.next = node.next;
                node.next = null;
                return node;
            }

            return null;
        }
    }
}
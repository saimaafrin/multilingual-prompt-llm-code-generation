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

                // Get the last node of current list
                ListNode<T> lastNode = null;
                if (head != null) {
                    lastNode = head;
                    while (lastNode.next != null) {
                        lastNode = lastNode.next;
                    }
                }

                // Move nodes from source list
                if (head == null) {
                    head = list.head;
                } else {
                    lastNode.next = list.head;
                }

                // Clear source list
                list.head = null;
            }
        }
    }

    // Supporting classes
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

            if (current.next != null) {
                current.next = node.next;
                node.next = null;
                return node;
            }

            return null;
        }
    }
}
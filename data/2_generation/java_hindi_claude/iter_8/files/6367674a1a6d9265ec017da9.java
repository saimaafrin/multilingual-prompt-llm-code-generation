import java.util.concurrent.atomic.AtomicReference;

public class LinkedList<T> {
    private ListNode<T> head;
    private final Object lock = new Object();

    public void moveAllNodes(LinkedList<T> list) {
        if (list == null || list.head == null) {
            return;
        }

        synchronized (lock) {
            synchronized (list.lock) {
                // Get the first and last nodes of source list
                ListNode<T> firstNode = list.head;
                ListNode<T> lastNode = firstNode;
                while (lastNode.next != null) {
                    lastNode = lastNode.next;
                }

                // Connect source list to end of current list
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
        }
    }

    public void removeListNode(ListNode<T> node) {
        synchronized (lock) {
            if (head == null || node == null) {
                return;
            }

            if (head == node) {
                head = head.next;
                return;
            }

            ListNode<T> current = head;
            while (current.next != null && current.next != node) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
            }
        }
    }
}
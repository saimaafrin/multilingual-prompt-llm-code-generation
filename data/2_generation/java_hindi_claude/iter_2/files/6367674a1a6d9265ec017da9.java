import java.util.concurrent.atomic.AtomicReference;

public class LinkedList<T> {
    private ListNode<T> head;
    private final Object lock = new Object();

    public void moveAllNodes(LinkedList<T> list) {
        if (list == null || list == this) {
            return;
        }

        synchronized (lock) {
            synchronized (list.lock) {
                // Store the current head of source list
                ListNode<T> sourceHead = list.head;
                
                if (sourceHead == null) {
                    return;
                }

                // Find the last node of source list
                ListNode<T> sourceTail = sourceHead;
                while (sourceTail.next != null) {
                    sourceTail = sourceTail.next;
                }

                // Connect source list to destination
                if (head == null) {
                    head = sourceHead;
                } else {
                    sourceTail.next = head;
                    head = sourceHead;
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
                node.next = head;
                head = node;
            }
        }
    }

    public ListNode<T> removeListNode(ListNode<T> node) {
        synchronized (lock) {
            if (head == null || node == null) {
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
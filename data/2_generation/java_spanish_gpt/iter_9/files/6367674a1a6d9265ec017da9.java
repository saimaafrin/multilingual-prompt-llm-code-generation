import java.util.NoSuchElementException;

class ListNode<E> {
    E data;
    ListNode<E> next;
    ListNode<E> prev;

    ListNode(E data) {
        this.data = data;
    }
}

class DoublyLinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;

    public void addListNode(ListNode<E> node) {
        if (node == null) return;
        if (head == null) {
            head = node;
            tail = node;
            node.next = null;
            node.prev = null;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = null;
        }
    }

    public void removeListNode(ListNode<E> node) {
        if (node == null) return;
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        node.next = null;
        node.prev = null;
    }

    public ListNode<E> getHead() {
        return head;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
}

public class Main<E> {
    private void moveAllListNodes(DoublyLinkedList<E> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        ListNode<E> currentNode = list.getHead();
        while (currentNode != null) {
            ListNode<E> nextNode = currentNode.next; // Store next node
            list.removeListNode(currentNode); // Remove from the original list
            addListNode(currentNode); // Add to this list
            currentNode = nextNode; // Move to the next node
        }
    }

    public static void main(String[] args) {
        // Example usage
        DoublyLinkedList<Integer> sourceList = new DoublyLinkedList<>();
        sourceList.addListNode(new ListNode<>(1));
        sourceList.addListNode(new ListNode<>(2));
        sourceList.addListNode(new ListNode<>(3));

        Main<Integer> mainList = new Main<>();
        mainList.moveAllListNodes(sourceList);
    }
}
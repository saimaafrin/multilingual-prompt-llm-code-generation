import java.util.Objects;

public class DoublyLinkedList<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    private static class ListNode<E> {
        E element;
        ListNode<E> next;
        ListNode<E> prev;

        ListNode(E element) {
            this.element = element;
        }
    }

    /**
     * Mueve atómicamente todos los {@link ListNode ListNodes} de {@code list} a esta lista 
     * como si cada nodo se hubiera eliminado con {@link #removeListNode(ListNodeImpl)} de {@code list} 
     * y posteriormente agregado a esta lista mediante {@link #addListNode(ListNodeImpl)}.
     */
    private void moveAllListNodes(DoublyLinkedList<E> list) {
        Objects.requireNonNull(list);
        
        if (list.size == 0 || list == this) {
            return;
        }

        // Si esta lista está vacía
        if (size == 0) {
            this.head = list.head;
            this.tail = list.tail;
        } else {
            // Conectar el final de esta lista con el inicio de la otra
            this.tail.next = list.head;
            list.head.prev = this.tail;
            this.tail = list.tail;
        }

        // Actualizar tamaños
        this.size += list.size;

        // Limpiar la lista original
        list.head = null;
        list.tail = null;
        list.size = 0;
    }
}
class ListNodeImpl<E> {
    E value;
    ListNodeImpl<E> next;

    ListNodeImpl(E value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedList<E> {
    private ListNodeImpl<E> head;

    public LinkedList() {
        this.head = null;
    }

    /**
     * Rimuove il nodo non nullo {@code node} dalla lista.
     */
    private boolean unlink(ListNodeImpl<E> node) {
        if (node == null) {
            return false;
        }

        // Caso speciale: il nodo da rimuovere è la testa
        if (node == head) {
            head = head.next;
            return true;
        }

        // Trova il nodo precedente a quello da rimuovere
        ListNodeImpl<E> current = head;
        while (current != null && current.next != node) {
            current = current.next;
        }

        // Se il nodo non è stato trovato nella lista
        if (current == null) {
            return false;
        }

        // Rimuovi il nodo dalla lista
        current.next = node.next;
        return true;
    }
}
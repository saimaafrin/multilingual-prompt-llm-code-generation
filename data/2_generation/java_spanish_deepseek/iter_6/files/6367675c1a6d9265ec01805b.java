// Asumiendo que la clase Node representa un nodo en una lista doblemente enlazada
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// Clase que representa una lista doblemente enlazada de bordes
class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Método para eliminar un nodo de la lista
    public void removeNode(Node node) {
        if (node == null) return;

        // Si el nodo es el único en la lista
        if (head == node && tail == node) {
            head = null;
            tail = null;
        } else if (head == node) {
            // Si el nodo es la cabeza
            head = head.next;
            head.prev = null;
        } else if (tail == node) {
            // Si el nodo es la cola
            tail = tail.prev;
            tail.next = null;
        } else {
            // Si el nodo está en medio
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}

// Clase que representa el árbol y sus bordes
class Tree {
    DoublyLinkedList edgeList1;
    DoublyLinkedList edgeList2;

    public Tree() {
        this.edgeList1 = new DoublyLinkedList();
        this.edgeList2 = new DoublyLinkedList();
    }

    // Método para eliminar un borde de ambas listas de bordes
    public void removeFromTreeEdgeList(Node edge) {
        if (edge == null) return;

        // Eliminar el borde de ambas listas
        edgeList1.removeNode(edge);
        edgeList2.removeNode(edge);
    }
}
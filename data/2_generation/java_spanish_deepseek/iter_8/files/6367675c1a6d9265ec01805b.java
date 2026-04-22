// Asumiendo que la clase que contiene este método tiene referencias a las listas doblemente enlazadas de bordes.
// También asumimos que la clase tiene un método para eliminar un borde específico de la lista.

public class Tree {
    // Lista doblemente enlazada de bordes
    private DoublyLinkedList<Edge> edgeList;

    // Constructor
    public Tree() {
        this.edgeList = new DoublyLinkedList<>();
    }

    // Método para eliminar un borde de ambas listas doblemente enlazadas de bordes del árbol
    public void removeFromTreeEdgeList(Edge edge) {
        if (edge == null) {
            throw new IllegalArgumentException("El borde no puede ser nulo.");
        }

        // Eliminar el borde de la lista doblemente enlazada
        edgeList.remove(edge);
    }

    // Clase interna para representar un borde
    public static class Edge {
        // Atributos del borde
        private int source;
        private int destination;

        // Constructor
        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }

        // Getters y setters
        public int getSource() {
            return source;
        }

        public int getDestination() {
            return destination;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return source == edge.source && destination == edge.destination;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination);
        }
    }

    // Clase interna para representar una lista doblemente enlazada
    public static class DoublyLinkedList<T> {
        private Node<T> head;
        private Node<T> tail;

        // Constructor
        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        // Método para eliminar un elemento de la lista
        public void remove(T data) {
            Node<T> current = head;
            while (current != null) {
                if (current.data.equals(data)) {
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    } else {
                        head = current.next;
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    } else {
                        tail = current.prev;
                    }
                    return;
                }
                current = current.next;
            }
        }

        // Clase interna para representar un nodo en la lista doblemente enlazada
        private static class Node<T> {
            T data;
            Node<T> prev;
            Node<T> next;

            // Constructor
            public Node(T data) {
                this.data = data;
                this.prev = null;
                this.next = null;
            }
        }
    }
}
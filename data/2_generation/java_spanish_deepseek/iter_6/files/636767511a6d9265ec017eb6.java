import java.util.function.Predicate;

public class OuterFaceCirculator {
    private Node current;

    public OuterFaceCirculator(Node start) {
        this.current = start;
    }

    public Node getCurrent() {
        return current;
    }

    public void next() {
        // Implementación de la lógica para moverse al siguiente nodo en la dirección dada
        // Esto es un placeholder, la implementación real dependerá de la estructura del grafo
        current = current.getNext(dir);
    }

    public void previous() {
        // Implementación de la lógica para moverse al nodo anterior en la dirección dada
        // Esto es un placeholder, la implementación real dependerá de la estructura del grafo
        current = current.getPrevious(dir);
    }
}

public class Node {
    private Node[] neighbors;
    private int id;

    public Node(int id) {
        this.id = id;
        this.neighbors = new Node[2]; // Asumiendo que cada nodo tiene dos vecinos (uno en cada dirección)
    }

    public Node getNext(int dir) {
        return neighbors[dir];
    }

    public Node getPrevious(int dir) {
        return neighbors[1 - dir];
    }

    public int getId() {
        return id;
    }
}

public class Graph {
    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);
        Node current = start;

        while (current != stop) {
            if (predicate.test(current)) {
                return circulator;
            }
            circulator.next();
            current = circulator.getCurrent();
        }

        // Si no se encuentra un nodo que satisfaga el predicado, devolver el circulator al nodo stop
        return circulator;
    }
}
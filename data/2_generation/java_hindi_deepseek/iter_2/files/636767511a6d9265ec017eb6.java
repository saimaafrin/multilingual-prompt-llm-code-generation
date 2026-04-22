import java.util.function.Predicate;

public class OuterFaceCirculator {
    private Node current;

    public OuterFaceCirculator(Node start) {
        this.current = start;
    }

    public Node next() {
        // Assuming the Node class has a method getNext(int dir) to get the next node in the given direction
        current = current.getNext(dir);
        return current;
    }

    public Node getCurrent() {
        return current;
    }
}

public class Node {
    private Node[] neighbors;

    public Node(Node[] neighbors) {
        this.neighbors = neighbors;
    }

    public Node getNext(int dir) {
        // Assuming dir is an index into the neighbors array
        return neighbors[dir];
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
            current = circulator.next();
        }

        // If the stop node is reached, return the circulator for the stop node
        return circulator;
    }
}
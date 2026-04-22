import java.util.function.Predicate;

public class OuterFaceCirculator {
    private Node current;

    public OuterFaceCirculator(Node node) {
        this.current = node;
    }

    public Node getCurrent() {
        return current;
    }

    public void next() {
        // Implement the logic to move to the next node in the outer face
        // This is a placeholder and should be replaced with actual traversal logic
        current = current.getNext(dir);
    }

    public void previous() {
        // Implement the logic to move to the previous node in the outer face
        // This is a placeholder and should be replaced with actual traversal logic
        current = current.getPrevious(dir);
    }
}

public class Node {
    private Node next;
    private Node previous;

    public Node getNext(int dir) {
        // Implement the logic to get the next node based on direction
        return next;
    }

    public Node getPrevious(int dir) {
        // Implement the logic to get the previous node based on direction
        return previous;
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

        return new OuterFaceCirculator(stop);
    }
}
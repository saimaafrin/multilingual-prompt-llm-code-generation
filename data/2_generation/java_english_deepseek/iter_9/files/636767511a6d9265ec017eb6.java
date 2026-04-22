import java.util.function.Predicate;

class Node {
    // Assuming Node class has necessary fields and methods
}

class OuterFaceCirculator {
    private Node current;

    public OuterFaceCirculator(Node start) {
        this.current = start;
    }

    public Node getCurrent() {
        return current;
    }

    public void next() {
        // Implement the logic to move to the next node in the outer face
    }

    public void previous() {
        // Implement the logic to move to the previous node in the outer face
    }
}

public class GraphTraversal {

    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);
        Node current = circulator.getCurrent();

        while (current != stop) {
            if (predicate.test(current)) {
                return circulator;
            }

            if (dir == 1) {
                circulator.next();
            } else {
                circulator.previous();
            }

            current = circulator.getCurrent();
        }

        return circulator;
    }
}
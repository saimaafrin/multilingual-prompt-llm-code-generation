import java.util.function.Predicate;

class Node {
    // Assume Node class has necessary fields and methods
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
        // Implement logic to move to the next node in the outer face
    }

    public void previous() {
        // Implement logic to move to the previous node in the outer face
    }
}

public class GraphTraversal {

    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);

        while (true) {
            Node currentNode = circulator.getCurrent();
            if (predicate.test(currentNode)) {
                return circulator;
            }
            if (currentNode.equals(stop)) {
                return circulator;
            }

            if (dir == 1) {
                circulator.next();
            } else {
                circulator.previous();
            }
        }
    }
}
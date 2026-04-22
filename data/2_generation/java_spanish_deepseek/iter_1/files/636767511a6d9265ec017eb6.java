import java.util.function.Predicate;

class Node {
    // Assuming Node class has necessary properties and methods
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
        // This is a placeholder and should be replaced with actual traversal logic
        current = current.getNextNode();
    }

    public void previous() {
        // Implement the logic to move to the previous node in the outer face
        // This is a placeholder and should be replaced with actual traversal logic
        current = current.getPreviousNode();
    }
}

public class GraphTraversal {

    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);

        while (true) {
            Node currentNode = circulator.getCurrent();

            // Check if the current node satisfies the predicate
            if (predicate.test(currentNode)) {
                return circulator;
            }

            // Check if we have reached the stop node
            if (currentNode.equals(stop)) {
                return circulator;
            }

            // Move to the next or previous node based on the direction
            if (dir == 1) {
                circulator.next();
            } else if (dir == -1) {
                circulator.previous();
            } else {
                throw new IllegalArgumentException("Invalid direction. Use 1 for next or -1 for previous.");
            }
        }
    }
}
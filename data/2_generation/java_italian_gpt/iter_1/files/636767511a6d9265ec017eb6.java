import java.util.function.Predicate;

class Node {
    // Assume Node class has necessary properties and methods
}

class OuterFaceCirculator {
    private Node currentNode;

    public OuterFaceCirculator(Node start) {
        this.currentNode = start;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void moveToNext() {
        // Logic to move to the next node in the outer face
    }
}

public class Graph {
    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);
        
        while (circulator.getCurrentNode() != stop) {
            if (predicate.test(circulator.getCurrentNode())) {
                return circulator;
            }
            circulator.moveToNext();
        }
        
        return circulator; // Return circulator at stop if no node satisfies the predicate
    }
}
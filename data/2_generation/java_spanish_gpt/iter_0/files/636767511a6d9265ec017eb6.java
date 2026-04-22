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

    public void advance(int dir) {
        // Logic to move to the next node in the specified direction
    }

    public boolean isAt(Node node) {
        return currentNode.equals(node);
    }
}

public class Graph {
    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);
        
        do {
            if (predicate.test(circulator.getCurrentNode())) {
                return circulator;
            }
            circulator.advance(dir);
        } while (!circulator.isAt(stop));
        
        return circulator; // Return circulator at stop if predicate not satisfied
    }
}
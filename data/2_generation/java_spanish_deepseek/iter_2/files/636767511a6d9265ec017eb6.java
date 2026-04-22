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
        // Assuming Node has a method getNext(int dir) to get the next node in the given direction
        current = current.getNext(dir);
    }

    public void previous() {
        // Assuming Node has a method getPrevious(int dir) to get the previous node in the given direction
        current = current.getPrevious(dir);
    }
}

public class Node {
    private Node next;
    private Node previous;

    public Node getNext(int dir) {
        // Implementation to get the next node based on direction
        return next;
    }

    public Node getPrevious(int dir) {
        // Implementation to get the previous node based on direction
        return previous;
    }
}

public class GraphTraversal {
    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);

        while (circulator.getCurrent() != stop) {
            if (predicate.test(circulator.getCurrent())) {
                return circulator;
            }
            circulator.next();
        }

        // If the predicate is not satisfied, return a circulator to the stop node
        return new OuterFaceCirculator(stop);
    }
}
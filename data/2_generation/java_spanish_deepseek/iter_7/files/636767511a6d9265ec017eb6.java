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
        // Assuming each node has a method to get the next node in the direction
        this.current = this.current.getNext(dir);
    }

    public void previous() {
        // Assuming each node has a method to get the previous node in the direction
        this.current = this.current.getPrevious(dir);
    }
}

public class Node {
    private Node next;
    private Node previous;

    public Node getNext(int dir) {
        return next;
    }

    public Node getPrevious(int dir) {
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

        return new OuterFaceCirculator(stop);
    }
}
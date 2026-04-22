import java.util.function.Predicate;

public class OuterFaceCirculator {
    private Node current;

    public OuterFaceCirculator(Node node) {
        this.current = node;
    }

    public Node getCurrent() {
        return current;
    }

    public void next(int dir) {
        // Assuming dir is 0 for clockwise and 1 for counter-clockwise
        if (dir == 0) {
            current = current.getNextClockwise();
        } else {
            current = current.getNextCounterClockwise();
        }
    }

    public void previous(int dir) {
        // Assuming dir is 0 for clockwise and 1 for counter-clockwise
        if (dir == 0) {
            current = current.getPreviousClockwise();
        } else {
            current = current.getPreviousCounterClockwise();
        }
    }
}

public class Node {
    private Node nextClockwise;
    private Node nextCounterClockwise;

    public Node getNextClockwise() {
        return nextClockwise;
    }

    public void setNextClockwise(Node nextClockwise) {
        this.nextClockwise = nextClockwise;
    }

    public Node getNextCounterClockwise() {
        return nextCounterClockwise;
    }

    public void setNextCounterClockwise(Node nextCounterClockwise) {
        this.nextCounterClockwise = nextCounterClockwise;
    }

    public Node getPreviousClockwise() {
        // Assuming previous clockwise is the next counter-clockwise of the next clockwise
        return nextClockwise != null ? nextClockwise.getNextCounterClockwise() : null;
    }

    public Node getPreviousCounterClockwise() {
        // Assuming previous counter-clockwise is the next clockwise of the next counter-clockwise
        return nextCounterClockwise != null ? nextCounterClockwise.getNextClockwise() : null;
    }
}

public class GraphTraversal {
    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);

        while (circulator.getCurrent() != stop) {
            if (predicate.test(circulator.getCurrent())) {
                return circulator;
            }
            circulator.next(dir);
        }

        // If the stop node is reached without finding a node that satisfies the predicate
        return new OuterFaceCirculator(stop);
    }
}
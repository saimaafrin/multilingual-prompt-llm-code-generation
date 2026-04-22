import java.util.function.Predicate;

public class OuterFaceCirculator {
    private Node current;

    public OuterFaceCirculator(Node start) {
        this.current = start;
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
}

public class Node {
    private Node nextClockwise;
    private Node nextCounterClockwise;

    public Node getNextClockwise() {
        return nextClockwise;
    }

    public Node getNextCounterClockwise() {
        return nextCounterClockwise;
    }

    // Other methods and fields...
}

public class Graph {
    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);

        while (circulator.getCurrent() != stop) {
            if (predicate.test(circulator.getCurrent())) {
                return circulator;
            }
            circulator.next(dir);
        }

        // If the loop ends, return the circulator pointing to the stop node
        return circulator;
    }
}
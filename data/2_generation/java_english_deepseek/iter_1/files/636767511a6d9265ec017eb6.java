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
        // Assuming dir is either 0 (clockwise) or 1 (counter-clockwise)
        if (dir == 0) {
            current = current.getNextClockwise();
        } else {
            current = current.getNextCounterClockwise();
        }
    }

    public void previous(int dir) {
        // Assuming dir is either 0 (clockwise) or 1 (counter-clockwise)
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

    public Node getNextCounterClockwise() {
        return nextCounterClockwise;
    }

    public Node getPreviousClockwise() {
        // Assuming previous clockwise is the next counter-clockwise of the next clockwise
        return nextClockwise.getNextCounterClockwise();
    }

    public Node getPreviousCounterClockwise() {
        // Assuming previous counter-clockwise is the next clockwise of the next counter-clockwise
        return nextCounterClockwise.getNextClockwise();
    }
}

public class Graph {
    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);
        Node current = circulator.getCurrent();

        while (current != stop) {
            if (predicate.test(current)) {
                return circulator;
            }
            circulator.next(dir);
            current = circulator.getCurrent();
        }

        // If the loop ends, it means we reached the stop node without finding a node that satisfies the predicate
        return circulator;
    }
}
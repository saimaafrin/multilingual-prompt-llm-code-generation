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
    private Node previousClockwise;
    private Node previousCounterClockwise;

    public Node getNextClockwise() {
        return nextClockwise;
    }

    public Node getNextCounterClockwise() {
        return nextCounterClockwise;
    }

    public Node getPreviousClockwise() {
        return previousClockwise;
    }

    public Node getPreviousCounterClockwise() {
        return previousCounterClockwise;
    }

    // Other methods and fields...
}

private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
    OuterFaceCirculator circulator = new OuterFaceCirculator(start);

    while (true) {
        Node currentNode = circulator.getCurrent();
        if (predicate.test(currentNode)) {
            return circulator;
        }
        if (currentNode == stop) {
            return circulator;
        }
        circulator.next(dir);
    }
}
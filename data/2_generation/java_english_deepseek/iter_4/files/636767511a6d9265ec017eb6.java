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
        // Assuming dir is either 0 (clockwise) or 1 (counter-clockwise)
        if (dir == 0) {
            current = current.getClockwiseNeighbor();
        } else {
            current = current.getCounterClockwiseNeighbor();
        }
    }

    public void previous(int dir) {
        // Assuming dir is either 0 (clockwise) or 1 (counter-clockwise)
        if (dir == 0) {
            current = current.getCounterClockwiseNeighbor();
        } else {
            current = current.getClockwiseNeighbor();
        }
    }
}

public class Node {
    private Node clockwiseNeighbor;
    private Node counterClockwiseNeighbor;

    public Node getClockwiseNeighbor() {
        return clockwiseNeighbor;
    }

    public void setClockwiseNeighbor(Node clockwiseNeighbor) {
        this.clockwiseNeighbor = clockwiseNeighbor;
    }

    public Node getCounterClockwiseNeighbor() {
        return counterClockwiseNeighbor;
    }

    public void setCounterClockwiseNeighbor(Node counterClockwiseNeighbor) {
        this.counterClockwiseNeighbor = counterClockwiseNeighbor;
    }
}

public class Graph {
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
}
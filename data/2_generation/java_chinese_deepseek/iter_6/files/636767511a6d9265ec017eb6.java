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

    public boolean isAt(Node node) {
        return current.equals(node);
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return this == node; // Assuming identity equality for simplicity
    }
}

public class Graph {
    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);

        while (!circulator.isAt(stop)) {
            if (predicate.test(circulator.getCurrent())) {
                return circulator;
            }
            circulator.next(dir);
        }

        // If we reach the stop node without finding a matching node, return the circulator pointing to stop
        return circulator;
    }
}
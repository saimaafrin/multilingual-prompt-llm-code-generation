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
        // Assuming dir is either 1 (clockwise) or -1 (counter-clockwise)
        if (dir == 1) {
            current = current.getNextClockwise();
        } else if (dir == -1) {
            current = current.getNextCounterClockwise();
        } else {
            throw new IllegalArgumentException("Invalid direction: " + dir);
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

public class GraphTraversal {
    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);

        while (!circulator.isAt(stop)) {
            Node currentNode = circulator.getCurrent();
            if (predicate.test(currentNode)) {
                return circulator;
            }
            circulator.next(dir);
        }

        return circulator;
    }
}
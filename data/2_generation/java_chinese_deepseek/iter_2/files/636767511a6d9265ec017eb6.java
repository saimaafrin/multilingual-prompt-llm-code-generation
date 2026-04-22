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
        // Assuming dir is 1 for clockwise and -1 for counter-clockwise
        if (dir == 1) {
            current = current.getNext();
        } else if (dir == -1) {
            current = current.getPrevious();
        } else {
            throw new IllegalArgumentException("Invalid direction: " + dir);
        }
    }

    public boolean isAt(Node node) {
        return current.equals(node);
    }
}

public class Node {
    private Node next;
    private Node previous;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
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
            Node currentNode = circulator.getCurrent();
            if (predicate.test(currentNode)) {
                return circulator;
            }
            circulator.next(dir);
        }

        // If we reach the stop node without finding a matching node, return the circulator pointing to stop
        return circulator;
    }
}
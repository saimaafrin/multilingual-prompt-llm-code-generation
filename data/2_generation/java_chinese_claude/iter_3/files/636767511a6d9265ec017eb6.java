import java.util.function.Predicate;

public class FaceTraversal {

    private class Node {
        // Node implementation details
    }

    private class OuterFaceCirculator {
        private Node current;
        
        public OuterFaceCirculator(Node node) {
            this.current = node;
        }
        
        public Node getCurrent() {
            return current;
        }
        
        public void advance(int direction) {
            // Implementation to move circulator in given direction
        }
        
        public boolean equals(OuterFaceCirculator other) {
            return this.current == other.current;
        }
    }

    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        if (start == null || stop == null) {
            return null;
        }

        OuterFaceCirculator circulator = new OuterFaceCirculator(start);
        OuterFaceCirculator stopCirculator = new OuterFaceCirculator(stop);

        // Check start node
        if (predicate.test(circulator.getCurrent())) {
            return circulator;
        }

        // Traverse until we find matching node or reach stop node
        while (!circulator.equals(stopCirculator)) {
            circulator.advance(dir);
            
            if (predicate.test(circulator.getCurrent())) {
                return circulator;
            }
        }

        // Return circulator pointing to stop node if no match found
        return stopCirculator;
    }
}
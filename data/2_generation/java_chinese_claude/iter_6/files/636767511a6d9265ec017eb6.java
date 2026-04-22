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
        
        public Node getNode() {
            return current;
        }
        
        // Other circulator methods
    }

    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        if (start == null || stop == null) {
            return null;
        }

        // Create circulator starting at the start node
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);
        
        // Keep traversing until we find a matching node or reach the stop node
        Node current = start;
        while (current != stop) {
            if (predicate.test(current)) {
                return new OuterFaceCirculator(current);
            }
            
            // Move to next node based on direction
            if (dir > 0) {
                // Move clockwise
                current = current.getNextClockwise();
            } else {
                // Move counter-clockwise  
                current = current.getNextCounterClockwise();
            }
            
            // Check if we've gone full circle
            if (current == start) {
                break;
            }
        }
        
        // Return circulator pointing to stop node if no match found
        return new OuterFaceCirculator(stop);
    }
}
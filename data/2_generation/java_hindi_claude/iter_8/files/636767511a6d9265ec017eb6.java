import java.util.function.Predicate;

public class BoundaryTraversal {
    
    private static class Node {
        Node next;
        Node prev;
        // other node properties
    }
    
    private static class Circulator {
        private Node current;
        
        public Circulator(Node node) {
            this.current = node;
        }
        
        public Node getNode() {
            return current;
        }
        
        public void advance() {
            current = current.next;
        }
        
        public void retreat() {
            current = current.prev;
        }
    }
    
    public enum Direction {
        FORWARD,
        BACKWARD
    }
    
    public Circulator findOnBoundary(Predicate<Node> predicate, Node start, Node stop, Direction dir) {
        if (start == null || stop == null) {
            return null;
        }
        
        Circulator circulator = new Circulator(start);
        
        // Check if start node satisfies predicate
        if (predicate.test(circulator.getNode())) {
            return circulator;
        }
        
        // Traverse boundary until we find matching node or reach stop node
        while (circulator.getNode() != stop) {
            if (dir == Direction.FORWARD) {
                circulator.advance();
            } else {
                circulator.retreat();
            }
            
            // Check if current node satisfies predicate
            if (predicate.test(circulator.getNode())) {
                return circulator;
            }
        }
        
        // Return circulator to stop node if no match found
        return new Circulator(stop);
    }
}
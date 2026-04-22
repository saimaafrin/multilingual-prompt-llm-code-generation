import java.util.function.Predicate;

public class Graph {
    
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
        
        public void moveNext() {
            // Implementation to move to next node
        }
        
        public void movePrev() {
            // Implementation to move to previous node
        }
    }
    
    /** 
     * Either finds and returns a circulator to the node on the boundary of the component, which satisfies the {@code predicate} or returns a circulator to the {@code stop} node.
     * @param predicate the condition the desired node should satisfy
     * @param start the node to start the search from
     * @param stop the node to end the search with
     * @param dir the direction to start the traversal in
     * @return a circulator to the node satisfying the {@code predicate} or to the {@code stop} node
     */
    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start);
        
        // If start node satisfies predicate, return immediately
        if (predicate.test(start)) {
            return circulator;
        }
        
        // Traverse boundary until we find matching node or reach stop node
        while (circulator.getCurrent() != stop) {
            if (dir > 0) {
                circulator.moveNext();
            } else {
                circulator.movePrev(); 
            }
            
            // Check if current node satisfies predicate
            if (predicate.test(circulator.getCurrent())) {
                return circulator;
            }
        }
        
        // Return circulator at stop node if no match found
        return circulator;
    }
}
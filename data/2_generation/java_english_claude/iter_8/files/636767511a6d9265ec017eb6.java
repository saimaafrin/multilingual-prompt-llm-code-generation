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
        
        public Node getNode() {
            return current;
        }
        
        public void next(int direction) {
            // Implementation to move to next node in given direction
        }
        
        public boolean equals(Node other) {
            return current.equals(other);
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
        
        // Continue traversing until we either find a node satisfying the predicate
        // or reach the stop node
        while (!circulator.equals(stop)) {
            if (predicate.test(circulator.getNode())) {
                return circulator;
            }
            circulator.next(dir);
        }
        
        // If no node satisfies predicate, return circulator at stop node
        return circulator;
    }
}
import java.util.function.Predicate;

public class GraphTraversal {

    private class Node {
        // Node implementation details
    }

    private class OuterFaceCirculator {
        private Node current;
        private int direction;

        public OuterFaceCirculator(Node node, int dir) {
            this.current = node;
            this.direction = dir;
        }

        public Node getNode() {
            return current;
        }

        public void next() {
            // Move to next node based on direction
        }
    }

    /**
     * Trova e restituisce un 'circulator' al nodo sul confine del componente, che soddisfa il {@code predicate} oppure restituisce un 'circulator' al nodo {@code stop}.
     * @param predicate la condizione che il nodo desiderato deve soddisfare
     * @param start il nodo da cui iniziare la ricerca
     * @param stop il nodo con cui terminare la ricerca 
     * @param dir la direzione da cui iniziare la traversata
     * @return un circolatore al nodo che soddisfa il {@code predicate} o al nodo {@code stop}
     */
    private OuterFaceCirculator selectOnOuterFace(Predicate<Node> predicate, Node start, Node stop, int dir) {
        OuterFaceCirculator circulator = new OuterFaceCirculator(start, dir);
        
        // Continue traversing until we find matching node or reach stop node
        while (!circulator.getNode().equals(stop)) {
            if (predicate.test(circulator.getNode())) {
                return circulator;
            }
            circulator.next();
        }
        
        // Return circulator at stop node if no match found
        return circulator;
    }
}
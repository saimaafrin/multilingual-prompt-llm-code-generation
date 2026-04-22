import java.util.LinkedList;

public class TreeEdge {
    private TreeEdge prev;
    private TreeEdge next;
    private Tree tree;

    /**
     * Rimuove questo arco da entrambe le liste doppiamente collegate degli archi dell'albero.
     */
    public void removeFromTreeEdgeList() {
        // Aggiorna i riferimenti del nodo precedente
        if (prev != null) {
            prev.next = next;
        } else if (tree != null) {
            // Se prev è null, questo è il primo elemento della lista
            tree.setFirstEdge(next);
        }

        // Aggiorna i riferimenti del nodo successivo
        if (next != null) {
            next.prev = prev;
        } else if (tree != null) {
            // Se next è null, questo è l'ultimo elemento della lista
            tree.setLastEdge(prev);
        }

        // Rimuovi i riferimenti da questo nodo
        prev = null;
        next = null;
        tree = null;
    }
}
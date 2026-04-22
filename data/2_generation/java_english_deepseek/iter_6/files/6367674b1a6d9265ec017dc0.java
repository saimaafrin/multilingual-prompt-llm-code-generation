import java.util.HashSet;
import java.util.Set;

/**
 * Compute all vertices that have positive degree by iterating over the edges on purpose. This keeps the complexity to $O(m)$ where $m$ is the number of edges.
 * @return set of vertices with positive degree
 */
private Set<V> initVisibleVertices() {
    Set<V> visibleVertices = new HashSet<>();
    for (Edge<V> edge : edges) {
        visibleVertices.add(edge.getSource());
        visibleVertices.add(edge.getTarget());
    }
    return visibleVertices;
}
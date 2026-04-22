import java.util.HashSet;
import java.util.Set;

private Set<V> initVisibleVertices() {
    Set<V> visibleVertices = new HashSet<>();
    for (Edge<V> edge : edges) {
        visibleVertices.add(edge.getSource());
        visibleVertices.add(edge.getTarget());
    }
    return visibleVertices;
}
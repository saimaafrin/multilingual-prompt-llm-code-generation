import java.util.HashSet;
import java.util.Set;

public class Graph<V> {
    private Set<V> vertices;
    private Set<Edge<V>> edges;

    public Graph() {
        this.vertices = new HashSet<>();
        this.edges = new HashSet<>();
    }

    public void addVertex(V vertex) {
        vertices.add(vertex);
    }

    public void addEdge(V from, V to) {
        edges.add(new Edge<>(from, to));
        vertices.add(from);
        vertices.add(to);
    }

    /** 
     * Compute all vertices that have positive degree by iterating over the edges on purpose. This keeps the complexity to $O(m)$ where $m$ is the number of edges.
     * @return set of vertices with positive degree
     */
    private Set<V> initVisibleVertices() {
        Set<V> visibleVertices = new HashSet<>();
        for (Edge<V> edge : edges) {
            visibleVertices.add(edge.from);
            visibleVertices.add(edge.to);
        }
        return visibleVertices;
    }

    private static class Edge<V> {
        V from;
        V to;

        Edge(V from, V to) {
            this.from = from;
            this.to = to;
        }
    }
}
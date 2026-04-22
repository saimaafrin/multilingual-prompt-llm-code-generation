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

    public void addEdge(V source, V destination) {
        edges.add(new Edge<>(source, destination));
        addVertex(source);
        addVertex(destination);
    }

    /** 
     * Compute all vertices that have positive degree by iterating over the edges on purpose. This keeps the complexity to $O(m)$ where $m$ is the number of edges.
     * @return set of vertices with positive degree
     */
    private Set<V> initVisibleVertices() {
        Set<V> visibleVertices = new HashSet<>();
        for (Edge<V> edge : edges) {
            visibleVertices.add(edge.getSource());
            visibleVertices.add(edge.getDestination());
        }
        return visibleVertices;
    }

    private static class Edge<V> {
        private V source;
        private V destination;

        public Edge(V source, V destination) {
            this.source = source;
            this.destination = destination;
        }

        public V getSource() {
            return source;
        }

        public V getDestination() {
            return destination;
        }
    }
}
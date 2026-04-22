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
        vertices.add(source);
        vertices.add(destination);
    }

    /** 
     * Calcula todos los vértices que tienen un grado positivo iterando sobre las aristas intencionadamente. 
     * Esto mantiene la complejidad en $O(m)$ donde $m$ es el número de aristas.
     * @return conjunto de vértices con grado positivo
     */
    private Set<V> initVisibleVertices() {
        Set<V> visibleVertices = new HashSet<>();
        for (Edge<V> edge : edges) {
            visibleVertices.add(edge.source);
            visibleVertices.add(edge.destination);
        }
        return visibleVertices;
    }

    private static class Edge<V> {
        V source;
        V destination;

        Edge(V source, V destination) {
            this.source = source;
            this.destination = destination;
        }
    }
}
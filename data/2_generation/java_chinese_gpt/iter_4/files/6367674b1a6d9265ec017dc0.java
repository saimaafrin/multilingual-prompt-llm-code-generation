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
     * 通过遍历边来计算所有具有正度的顶点。这将复杂度保持在 $O(m)$，其中 $m$ 是边的数量。
     * @return 具有正度的顶点集合
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
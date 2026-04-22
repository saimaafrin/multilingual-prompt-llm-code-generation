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
        addVertex(from);
        addVertex(to);
    }

    /** 
     * सभी वर्टिस को गणना करें जिनका डिग्री सकारात्मक है, जानबूझकर किनारों पर इटरेट करके। यह जटिलता को $O(m)$ पर रखता है जहाँ $m$ किनारों की संख्या है।
     * @return सकारात्मक डिग्री वाले वर्टिस का सेट
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
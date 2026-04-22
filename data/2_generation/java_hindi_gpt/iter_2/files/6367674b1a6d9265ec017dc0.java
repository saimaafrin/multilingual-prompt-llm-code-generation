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
     * सभी वर्टिस को गणना करें जिनका डिग्री सकारात्मक है, जानबूझकर किनारों पर इटरेट करके। यह जटिलता को $O(m)$ पर रखता है जहाँ $m$ किनारों की संख्या है।
     * @return सकारात्मक डिग्री वाले वर्टिस का सेट
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
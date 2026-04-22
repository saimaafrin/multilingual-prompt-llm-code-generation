import java.util.*;

public class Graph<V> {
    private Map<V, Set<V>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(V vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void addEdge(V source, V destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    /**
     * सभी वर्टिस को गणना करें जिनका डिग्री सकारात्मक है, जानबूझकर किनारों पर इटरेट करके। यह जटिलता को $O(m)$ पर रखता है जहाँ $m$ किनारों की संख्या है।
     * @return सकारात्मक डिग्री वाले वर्टिस का सेट
     */
    private Set<V> initVisibleVertices() {
        Set<V> visibleVertices = new HashSet<>();
        for (Map.Entry<V, Set<V>> entry : adjacencyList.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                visibleVertices.add(entry.getKey());
            }
        }
        return visibleVertices;
    }

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");

        Set<String> visibleVertices = graph.initVisibleVertices();
        System.out.println("Visible Vertices: " + visibleVertices);
    }
}
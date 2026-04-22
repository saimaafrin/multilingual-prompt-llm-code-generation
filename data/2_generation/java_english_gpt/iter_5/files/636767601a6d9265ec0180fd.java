import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V, E> {
    private Map<V, Set<Edge<E>>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    /** 
     * Add an edge to the index.
     * @param sourceVertex the source vertex
     * @param targetVertex the target vertex
     * @param e the edge
     */
    protected void addToIndex(V sourceVertex, V targetVertex, E e) {
        adjacencyList.putIfAbsent(sourceVertex, new HashSet<>());
        adjacencyList.putIfAbsent(targetVertex, new HashSet<>());
        adjacencyList.get(sourceVertex).add(new Edge<>(targetVertex, e));
    }

    private static class Edge<E> {
        V targetVertex;
        E edge;

        Edge(V targetVertex, E edge) {
            this.targetVertex = targetVertex;
            this.edge = edge;
        }
    }
}
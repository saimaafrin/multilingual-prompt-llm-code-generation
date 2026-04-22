import java.util.*;

public class Graph {
    private Set<Integer> visitedVertices;
    private Set<Integer> allVertices;

    public Graph(Set<Integer> allVertices) {
        this.allVertices = allVertices;
        this.visitedVertices = new HashSet<>();
    }

    /**
     * Verifica si existen vértices no visitados.
     * @return true si existen vértices no visitados.
     */
    @Override
    public boolean hasNext() {
        return !visitedVertices.containsAll(allVertices);
    }

    // Other methods to manage the graph and visited vertices...
}
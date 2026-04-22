import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<Integer> visitedVertices;
    private Set<Integer> allVertices;

    public Graph(Set<Integer> allVertices) {
        this.allVertices = allVertices;
        this.visitedVertices = new HashSet<>();
    }

    /**
     * Checks whether there exist unvisited vertices.
     * @return true if there exist unvisited vertices.
     */
    @Override 
    public boolean hasNext() {
        for (Integer vertex : allVertices) {
            if (!visitedVertices.contains(vertex)) {
                return true;
            }
        }
        return false;
    }

    public void visitVertex(int vertex) {
        visitedVertices.add(vertex);
    }
}
import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<Integer> visited;
    private Set<Integer> allVertices;

    public Graph(Set<Integer> allVertices) {
        this.allVertices = allVertices;
        this.visited = new HashSet<>();
    }

    /** 
     * Checks whether there exist unvisited vertices.
     * @return true if there exist unvisited vertices.
     */
    @Override 
    public boolean hasNext() {
        for (Integer vertex : allVertices) {
            if (!visited.contains(vertex)) {
                return true;
            }
        }
        return false;
    }

    public void visitVertex(int vertex) {
        visited.add(vertex);
    }
}
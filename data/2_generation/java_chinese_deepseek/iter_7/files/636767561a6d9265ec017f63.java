import java.util.*;

public class GraphTraversal {
    private Set<Integer> visited;
    private Set<Integer> vertices;

    public GraphTraversal(Set<Integer> vertices) {
        this.vertices = vertices;
        this.visited = new HashSet<>();
    }

    @Override
    public boolean hasNext() {
        for (Integer vertex : vertices) {
            if (!visited.contains(vertex)) {
                return true;
            }
        }
        return false;
    }
}
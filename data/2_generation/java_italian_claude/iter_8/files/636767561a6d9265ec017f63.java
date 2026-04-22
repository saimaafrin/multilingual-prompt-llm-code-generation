import java.util.*;

public class GraphTraversal implements Iterator<Vertex> {
    private boolean[] visited;
    private int numVertices;
    
    @Override
    public boolean hasNext() {
        // Iterate through visited array to check for unvisited vertices
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                return true;
            }
        }
        return false;
    }
}
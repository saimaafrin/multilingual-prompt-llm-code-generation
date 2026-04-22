import java.util.*;

public class Graph {
    private boolean[] visited;
    private int currentVertex;
    private int numVertices;
    
    public Graph(int v) {
        numVertices = v;
        visited = new boolean[v];
        currentVertex = 0;
    }

    @Override
    public boolean hasNext() {
        // Check if there are any unvisited vertices remaining
        for (int i = currentVertex; i < numVertices; i++) {
            if (!visited[i]) {
                return true;
            }
        }
        return false;
    }
}
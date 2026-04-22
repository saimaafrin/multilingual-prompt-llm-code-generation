import java.util.*;

public class GraphIterator implements Iterator<Vertex> {
    private boolean[] visited;
    private int numVertices;
    
    public GraphIterator(int n) {
        numVertices = n;
        visited = new boolean[numVertices];
    }

    @Override
    public boolean hasNext() {
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                return true;
            }
        }
        return false;
    }
}
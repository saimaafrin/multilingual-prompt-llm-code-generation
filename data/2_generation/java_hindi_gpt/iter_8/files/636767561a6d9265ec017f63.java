import java.util.Iterator;

public class GraphIterator implements Iterator<Integer> {
    private boolean[] visited;
    private int currentVertex;
    private int totalVertices;

    public GraphIterator(int totalVertices) {
        this.totalVertices = totalVertices;
        this.visited = new boolean[totalVertices];
        this.currentVertex = 0; // Start from the first vertex
    }

    @Override
    public boolean hasNext() {
        for (int i = currentVertex; i < totalVertices; i++) {
            if (!visited[i]) {
                return true; // Found an unvisited vertex
            }
        }
        return false; // No unvisited vertices found
    }

    // Other methods like next() would be implemented here
}
import java.util.Iterator;
import java.util.List;

public class GraphIterator implements Iterator<Integer> {
    private List<Integer> vertices;
    private boolean[] visited;
    private int currentIndex;

    public GraphIterator(List<Integer> vertices) {
        this.vertices = vertices;
        this.visited = new boolean[vertices.size()];
        this.currentIndex = 0;
    }

    /** 
     * Checks whether there exist unvisited vertices.
     * @return true if there exist unvisited vertices.
     */
    @Override
    public boolean hasNext() {
        while (currentIndex < vertices.size()) {
            if (!visited[currentIndex]) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("No unvisited vertices available.");
        }
        int vertex = vertices.get(currentIndex);
        visited[currentIndex] = true;
        currentIndex++;
        return vertex;
    }
}
import java.util.Iterator;
import java.util.List;

public class GraphIterator implements Iterator<Vertex> {
    private List<Vertex> vertices;
    private boolean[] visited;
    private int currentIndex;

    public GraphIterator(List<Vertex> vertices) {
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

    // Other methods like next() and remove() would be implemented here
}
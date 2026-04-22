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
     * 检查是否存在未访问的顶点。
     * @return 如果存在未访问的顶点，则返回真。
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
        if (hasNext()) {
            visited[currentIndex] = true;
            return vertices.get(currentIndex++);
        }
        throw new IllegalStateException("No more vertices to visit.");
    }
}
import java.util.*;

public class GraphTraversal {
    private Set<Integer> visited;
    private Set<Integer> vertices;

    public GraphTraversal(Set<Integer> vertices) {
        this.vertices = vertices;
        this.visited = new HashSet<>();
    }

    /** 
     * 检查是否存在未访问的顶点。
     * @return 如果存在未访问的顶点，则返回真。
     */
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
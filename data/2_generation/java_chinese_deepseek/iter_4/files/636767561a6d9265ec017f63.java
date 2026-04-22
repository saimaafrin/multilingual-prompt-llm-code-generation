import java.util.*;

public class Graph {
    private boolean[] visited;

    public Graph(int vertexCount) {
        visited = new boolean[vertexCount];
    }

    /** 
     * 检查是否存在未访问的顶点。
     * @return 如果存在未访问的顶点，则返回真。
     */
    @Override
    public boolean hasNext() {
        for (boolean v : visited) {
            if (!v) {
                return true;
            }
        }
        return false;
    }
}
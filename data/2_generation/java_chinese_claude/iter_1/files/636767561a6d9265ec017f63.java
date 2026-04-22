import java.util.*;

public class Graph {
    private boolean[] visited;
    private int currentVertex;
    private final int vertices;
    
    public Graph(int v) {
        vertices = v;
        visited = new boolean[v];
        currentVertex = 0;
    }

    @Override
    public boolean hasNext() {
        // 从当前位置开始查找下一个未访问的顶点
        while (currentVertex < vertices) {
            if (!visited[currentVertex]) {
                return true;
            }
            currentVertex++;
        }
        return false;
    }
}
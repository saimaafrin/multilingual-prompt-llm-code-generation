import java.util.Set;

public class Graph<V> {
    private double[][] adjacencyMatrix; // 假设使用邻接矩阵表示图
    private int vertexCount;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.adjacencyMatrix = new double[vertexCount][vertexCount];
    }

    /**
     * 计算进入一个顶点的权重总和
     * @param v 顶点
     * @return 进入一个顶点的权重总和
     */
    public double vertexWeight(Set<V> v) {
        double totalWeight = 0.0;
        for (V vertex : v) {
            int vertexIndex = getVertexIndex(vertex);
            for (int i = 0; i < vertexCount; i++) {
                totalWeight += adjacencyMatrix[i][vertexIndex];
            }
        }
        return totalWeight;
    }

    // 假设有一个方法将顶点转换为索引
    private int getVertexIndex(V vertex) {
        // 这里假设顶点可以直接转换为索引
        // 实际实现可能依赖于具体的顶点类型
        return (int) vertex;
    }
}
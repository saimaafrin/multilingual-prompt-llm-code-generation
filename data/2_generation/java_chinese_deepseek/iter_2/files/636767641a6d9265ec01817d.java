import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class BipartiteGraphGenerator<V, E> {

    /**
     * 构建一个完整的二分图
     * @param target 目标图对象
     * @param resultMap 用于存储生成的顶点
     */
    @Override
    public void generateGraph(Graph<V, E> target, Map<String, V> resultMap) {
        // 假设我们有两组顶点，分别命名为 "A" 和 "B"
        List<V> groupA = new ArrayList<>();
        List<V> groupB = new ArrayList<>();

        // 创建顶点并添加到对应的组中
        for (int i = 0; i < 5; i++) {
            V vertexA = target.addVertex();
            groupA.add(vertexA);
            resultMap.put("A" + i, vertexA);

            V vertexB = target.addVertex();
            groupB.add(vertexB);
            resultMap.put("B" + i, vertexB);
        }

        // 在两组顶点之间创建边
        for (V a : groupA) {
            for (V b : groupB) {
                target.addEdge(a, b);
            }
        }
    }
}

// 假设的 Graph 接口
interface Graph<V, E> {
    V addVertex();
    E addEdge(V source, V target);
}
import java.util.*;

public class GraphLabeling {
    /**
     * 将所有标签为 {@code minLabel} 的桶中的顶点移动到标签为 0 的桶中。清空标签为 {@code minLabel} 的桶。相应地更新标签。
     * @param bucketsByLabel 存储顶点的桶
     * @param labels 顶点的标签
     * @param minLabel 非空桶的最小值
     */
    private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
        // 获取标签为minLabel的桶中的所有顶点
        Set<Integer> vertices = bucketsByLabel.get(minLabel);
        
        // 将这些顶点的标签更新为0
        for (Integer vertex : vertices) {
            labels.set(vertex, 0);
        }
        
        // 将这些顶点移动到标签为0的桶中
        bucketsByLabel.get(0).addAll(vertices);
        
        // 清空标签为minLabel的桶
        vertices.clear();
    }
}
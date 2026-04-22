import java.util.List;
import java.util.Set;

private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
    // 获取标签为 minLabel 的桶
    Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
    
    // 遍历 minLabel 桶中的所有顶点
    for (int vertex : minLabelBucket) {
        // 将顶点的标签更新为 0
        labels.set(vertex, 0);
        // 将顶点移动到标签为 0 的桶中
        bucketsByLabel.get(0).add(vertex);
    }
    
    // 清空标签为 minLabel 的桶
    minLabelBucket.clear();
}
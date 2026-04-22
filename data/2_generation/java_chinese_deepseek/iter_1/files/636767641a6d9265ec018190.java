import java.util.List;
import java.util.Set;

private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
    // 获取标签为 minLabel 的桶
    Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
    
    // 获取标签为 0 的桶
    Set<Integer> zeroLabelBucket = bucketsByLabel.get(0);
    
    // 将所有顶点从 minLabel 桶移动到 0 桶
    zeroLabelBucket.addAll(minLabelBucket);
    
    // 清空 minLabel 桶
    minLabelBucket.clear();
    
    // 更新这些顶点的标签为 0
    for (int vertex : zeroLabelBucket) {
        labels.set(vertex, 0);
    }
}
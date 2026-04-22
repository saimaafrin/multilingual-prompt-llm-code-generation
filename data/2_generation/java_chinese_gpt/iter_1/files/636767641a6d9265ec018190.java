import java.util.List;
import java.util.Set;

public class BucketRelocator {

    /**
     * 将所有标签为 {@code minLabel} 的桶中的顶点移动到标签为 0 的桶中。清空标签为 {@code minLabel} 的桶。相应地更新标签。
     * @param bucketsByLabel 存储顶点的桶
     * @param labels 顶点的标签
     * @param minLabel 非空桶的最小值
     */
    private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
        // 获取标签为 minLabel 的桶
        Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
        
        // 获取标签为 0 的桶
        Set<Integer> zeroLabelBucket = bucketsByLabel.get(0);
        
        // 将标签为 minLabel 的桶中的顶点移动到标签为 0 的桶中
        for (Integer vertex : minLabelBucket) {
            zeroLabelBucket.add(vertex);
            labels.set(vertex, 0); // 更新标签为 0
        }
        
        // 清空标签为 minLabel 的桶
        minLabelBucket.clear();
    }
}
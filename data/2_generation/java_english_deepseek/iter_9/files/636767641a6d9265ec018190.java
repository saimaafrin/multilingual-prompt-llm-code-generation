import java.util.List;
import java.util.Set;

private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
    // Get the bucket with the minLabel
    Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
    
    // Move all vertices from the minLabel bucket to the bucket with label 0
    Set<Integer> zeroLabelBucket = bucketsByLabel.get(0);
    zeroLabelBucket.addAll(minLabelBucket);
    
    // Clear the minLabel bucket
    minLabelBucket.clear();
    
    // Update the labels of the moved vertices to 0
    for (int vertex : zeroLabelBucket) {
        labels.set(vertex, 0);
    }
}
import java.util.List;
import java.util.Set;

private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
    // Get the bucket with the minLabel
    Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
    
    // Move all vertices from minLabel bucket to label 0 bucket
    Set<Integer> labelZeroBucket = bucketsByLabel.get(0);
    labelZeroBucket.addAll(minLabelBucket);
    
    // Clear the minLabel bucket
    minLabelBucket.clear();
    
    // Update the labels of the vertices that were moved
    for (int vertex : labelZeroBucket) {
        labels.set(vertex, 0);
    }
}
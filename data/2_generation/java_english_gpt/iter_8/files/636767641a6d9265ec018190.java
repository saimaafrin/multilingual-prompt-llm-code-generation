import java.util.List;
import java.util.Set;

public class VertexMover {

    /** 
     * Moves all vertices from the bucket with label  {@code minLabel} to the bucket with label 0.
     * Clears the bucket with label  {@code minLabel}. Updates the labeling accordingly.
     * @param bucketsByLabel the buckets vertices are stored in
     * @param labels the labels of the vertices
     * @param minLabel the minimum value of the non-empty bucket
     */
    private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
        // Get the bucket with the minLabel
        Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
        
        // Move all vertices from minLabel bucket to the bucket with label 0
        Set<Integer> zeroLabelBucket = bucketsByLabel.get(0);
        zeroLabelBucket.addAll(minLabelBucket);
        
        // Clear the minLabel bucket
        minLabelBucket.clear();
        
        // Update the labels of the vertices that were moved
        for (Integer vertex : zeroLabelBucket) {
            labels.set(vertex, 0);
        }
    }
}
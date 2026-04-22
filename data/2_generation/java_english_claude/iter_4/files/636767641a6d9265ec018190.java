import java.util.*;

public class BucketLabeler {

    /**
     * Moves all vertices from the bucket with label {@code minLabel} to the bucket with label 0.
     * Clears the bucket with label {@code minLabel}. Updates the labeling accordingly.
     * @param bucketsByLabel the buckets vertices are stored in
     * @param labels the labels of the vertices
     * @param minLabel the minimum value of the non-empty bucket
     */
    private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
        // Get vertices from minLabel bucket
        Set<Integer> vertices = bucketsByLabel.get(minLabel);
        
        // Move vertices to bucket 0
        bucketsByLabel.get(0).addAll(vertices);
        
        // Update labels for moved vertices
        for (Integer vertex : vertices) {
            labels.set(vertex, 0);
        }
        
        // Clear minLabel bucket
        vertices.clear();
    }
}
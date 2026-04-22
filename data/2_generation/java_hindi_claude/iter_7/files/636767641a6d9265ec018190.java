import java.util.*;

public class BucketLabeler {
    
    public void moveVerticesFromMinLabelBucketToZero(
        Map<Integer, Set<Integer>> bucketsByLabel,
        Map<Integer, Integer> labels,
        int minLabel
    ) {
        // Get vertices from min label bucket
        Set<Integer> verticesToMove = bucketsByLabel.get(minLabel);
        
        if (verticesToMove == null || verticesToMove.isEmpty()) {
            return;
        }

        // Get or create bucket 0
        Set<Integer> zeroBucket = bucketsByLabel.computeIfAbsent(0, k -> new HashSet<>());
        
        // Move all vertices to bucket 0 and update their labels
        for (Integer vertex : verticesToMove) {
            zeroBucket.add(vertex);
            labels.put(vertex, 0);
        }
        
        // Clear the min label bucket
        verticesToMove.clear();
        bucketsByLabel.remove(minLabel);
    }
}
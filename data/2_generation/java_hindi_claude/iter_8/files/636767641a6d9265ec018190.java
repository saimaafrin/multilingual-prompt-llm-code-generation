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

        // Create bucket 0 if it doesn't exist
        bucketsByLabel.putIfAbsent(0, new HashSet<>());
        Set<Integer> zeroBucket = bucketsByLabel.get(0);

        // Move vertices to bucket 0 and update labels
        for (Integer vertex : verticesToMove) {
            zeroBucket.add(vertex);
            labels.put(vertex, 0);
        }

        // Clear min label bucket
        verticesToMove.clear();
        bucketsByLabel.remove(minLabel);
    }
}
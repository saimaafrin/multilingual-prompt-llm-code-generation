import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShardingKeyValidator {

    /**
     * @param modelName model name of the entity
     * @throws IllegalStateException if sharding key indices are not continuous
     */
    public void validateShardingKeyIndices(String modelName) {
        List<Integer> indices = getShardingKeyIndices(modelName);
        
        if (indices.isEmpty()) {
            return;
        }

        Collections.sort(indices);
        
        for (int i = 0; i < indices.size() - 1; i++) {
            if (indices.get(i + 1) - indices.get(i) != 1) {
                throw new IllegalStateException("Sharding key indices must be continuous for model: " + modelName);
            }
        }
    }

    // Helper method to get sharding key indices
    private List<Integer> getShardingKeyIndices(String modelName) {
        // Implementation would retrieve indices from model metadata
        // Returning empty list for example
        return new ArrayList<>();
    }
}
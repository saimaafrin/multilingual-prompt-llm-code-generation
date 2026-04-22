import java.util.Objects;

public class ShardingKeyValidator {
    
    /**
     * @param modelName model name of the entity
     * @throws IllegalStateException if sharding key indices are not continuous
     */
    private void check(String modelName) throws IllegalStateException {
        if (Objects.isNull(modelName) || modelName.trim().isEmpty()) {
            throw new IllegalStateException("Model name cannot be null or empty");
        }
        
        // Validate that model name follows expected format
        if (!modelName.matches("^[a-zA-Z0-9_]+$")) {
            throw new IllegalStateException("Model name contains invalid characters");
        }
        
        // Check if sharding key indices are continuous
        // This is a placeholder implementation - actual logic would depend on how indices are stored/retrieved
        int[] indices = getShardingKeyIndices(modelName);
        if (indices != null && indices.length > 0) {
            for (int i = 0; i < indices.length - 1; i++) {
                if (indices[i + 1] - indices[i] != 1) {
                    throw new IllegalStateException("Sharding key indices are not continuous for model: " + modelName);
                }
            }
        }
    }
    
    // Helper method to get sharding indices - implementation would depend on actual data source
    private int[] getShardingKeyIndices(String modelName) {
        // Placeholder implementation
        return new int[]{0, 1, 2, 3};
    }
}
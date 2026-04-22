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
        
        // Assuming sharding key indices are stored in a list/array
        // This is a sample implementation - actual logic would depend on how indices are stored
        int[] indices = getShardingKeyIndices(modelName);
        
        if (indices.length == 0) {
            return; // No sharding keys to validate
        }
        
        // Check if indices are continuous (no gaps)
        for (int i = 0; i < indices.length - 1; i++) {
            if (indices[i + 1] != indices[i] + 1) {
                throw new IllegalStateException(
                    String.format("Non-continuous sharding key indices found for model %s", modelName)
                );
            }
        }
    }
    
    // Helper method to get sharding indices
    private int[] getShardingKeyIndices(String modelName) {
        // Implementation would depend on how indices are actually stored
        // This is just a placeholder
        return new int[0];
    }
}
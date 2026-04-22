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
        // This is a placeholder implementation - actual logic would depend on
        // how sharding keys are maintained
        int[] shardingKeyIndices = getShardingKeyIndices(modelName);
        
        if (shardingKeyIndices.length == 0) {
            return; // No sharding keys to validate
        }
        
        // Check if indices are continuous
        for (int i = 0; i < shardingKeyIndices.length - 1; i++) {
            if (shardingKeyIndices[i + 1] - shardingKeyIndices[i] != 1) {
                throw new IllegalStateException(
                    "Sharding key indices must be continuous for model: " + modelName
                );
            }
        }
    }
    
    // Helper method to get sharding key indices
    private int[] getShardingKeyIndices(String modelName) {
        // Implementation would depend on how indices are stored
        // This is just a placeholder
        return new int[0];
    }
}
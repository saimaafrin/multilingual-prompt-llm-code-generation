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
        
        // Assuming this is part of a larger class that validates sharding keys
        // This is a basic implementation that checks if model name exists
        // Additional validation logic for sharding key indices continuity would go here
        // based on the specific requirements of the sharding implementation
        
        try {
            validateShardingIndices(modelName);
        } catch (Exception e) {
            throw new IllegalStateException("Sharding key indices are not continuous for model: " + modelName);
        }
    }
    
    // Helper method to validate sharding indices
    private void validateShardingIndices(String modelName) {
        // Implementation would depend on how sharding indices are stored/managed
        // This is just a placeholder
    }
}
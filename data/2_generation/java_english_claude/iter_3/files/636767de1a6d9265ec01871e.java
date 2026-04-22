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

        // Validate that sharding key indices are continuous
        // This is a basic implementation - extend based on actual requirements
        try {
            validateShardingKeyIndices(modelName);
        } catch (Exception e) {
            throw new IllegalStateException("Sharding key indices are not continuous for model: " + modelName, e);
        }
    }

    private void validateShardingKeyIndices(String modelName) {
        // Implementation of sharding key validation logic would go here
        // This is just a placeholder method
    }
}
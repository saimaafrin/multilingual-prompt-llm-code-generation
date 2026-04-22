import java.util.Objects;

public class ShardingChecker {

    /**
     * @param modelName 实体的模型名称
     * @throws IllegalStateException 如果分片键索引不连续
     */
    private void check(String modelName) throws IllegalStateException {
        if (Objects.isNull(modelName) || modelName.trim().isEmpty()) {
            throw new IllegalStateException("Model name cannot be null or empty");
        }

        // Validate model name format
        if (!modelName.matches("^[a-zA-Z0-9_]+$")) {
            throw new IllegalStateException("Invalid model name format: " + modelName);
        }

        // Check if sharding key indexes are continuous
        try {
            validateShardingKeyIndexes(modelName);
        } catch (Exception e) {
            throw new IllegalStateException("Discontinuous sharding key indexes found for model: " + modelName, e);
        }
    }

    private void validateShardingKeyIndexes(String modelName) {
        // Implementation of sharding key index validation logic would go here
        // This is just a placeholder method to demonstrate the structure
    }
}
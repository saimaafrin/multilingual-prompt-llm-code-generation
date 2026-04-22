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

        // Verify model name format
        if (!modelName.matches("^[a-zA-Z][a-zA-Z0-9_]*$")) {
            throw new IllegalStateException("Invalid model name format: " + modelName);
        }

        // Check for continuous sharding key index
        try {
            validateShardingKeyIndex(modelName);
        } catch (Exception e) {
            throw new IllegalStateException("Discontinuous sharding key index found for model: " + modelName, e);
        }
    }

    private void validateShardingKeyIndex(String modelName) {
        // Implementation of sharding key index validation logic
        // This is a placeholder - actual implementation would depend on
        // how sharding keys are stored and what makes them "continuous"
    }
}
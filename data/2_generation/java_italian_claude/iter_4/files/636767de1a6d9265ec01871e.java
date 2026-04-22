import java.util.Objects;

public class ShardingValidator {
    /**
     * @param modelName nome del modello dell'entità
     * @throws IllegalStateException se gli indici della chiave di sharding non sono continui
     */
    private void check(String modelName) throws IllegalStateException {
        if (Objects.isNull(modelName) || modelName.trim().isEmpty()) {
            throw new IllegalStateException("Model name cannot be null or empty");
        }

        // Verify that sharding key indices are continuous
        int[] indices = getShardingKeyIndices(modelName);
        if (indices != null && indices.length > 0) {
            for (int i = 0; i < indices.length - 1; i++) {
                if (indices[i + 1] - indices[i] != 1) {
                    throw new IllegalStateException("Sharding key indices must be continuous for model: " + modelName);
                }
            }
        }
    }

    // Helper method to get sharding key indices
    private int[] getShardingKeyIndices(String modelName) {
        // Implementation would depend on how sharding keys are stored/retrieved
        // This is just a placeholder
        return new int[]{0, 1, 2};
    }
}
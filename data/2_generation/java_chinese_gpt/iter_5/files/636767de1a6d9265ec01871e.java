public class ModelChecker {

    /**
     * @param modelName 实体的模型名称
     * @throws IllegalStateException 如果分片键索引不连续
     */
    private void check(String modelName) throws IllegalStateException {
        // Example implementation: Check if the modelName is valid and if the shard keys are continuous
        if (modelName == null || modelName.isEmpty()) {
            throw new IllegalStateException("Model name cannot be null or empty");
        }

        // Simulated shard key index check (this is just a placeholder for actual logic)
        int[] shardKeys = getShardKeys(modelName); // Assume this method retrieves shard keys for the model
        for (int i = 0; i < shardKeys.length - 1; i++) {
            if (shardKeys[i] + 1 != shardKeys[i + 1]) {
                throw new IllegalStateException("Shard key indices are not continuous for model: " + modelName);
            }
        }
    }

    // Placeholder method to simulate retrieval of shard keys
    private int[] getShardKeys(String modelName) {
        // This should return the actual shard keys based on the modelName
        return new int[]{1, 2, 3}; // Example of continuous shard keys
    }

    public static void main(String[] args) {
        ModelChecker checker = new ModelChecker();
        try {
            checker.check("ExampleModel");
            System.out.println("Model check passed.");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}
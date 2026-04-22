public class ModelChecker {

    /**
     * @param modelName 实体的模型名称
     * @throws IllegalStateException 如果分片键索引不连续
     */
    private void check(String modelName) throws IllegalStateException {
        // Simulated logic for checking shard key continuity
        // In a real scenario, this would involve checking the actual model's shard key indices
        int[] shardKeys = getShardKeys(modelName); // Assume this method retrieves the shard keys for the model
        for (int i = 0; i < shardKeys.length - 1; i++) {
            if (shardKeys[i] + 1 != shardKeys[i + 1]) {
                throw new IllegalStateException("分片键索引不连续: " + modelName);
            }
        }
    }

    // Mock method to simulate retrieval of shard keys
    private int[] getShardKeys(String modelName) {
        // This is just a placeholder. In a real implementation, this would fetch the actual shard keys.
        return new int[]{1, 2, 3}; // Example of continuous shard keys
    }

    public static void main(String[] args) {
        ModelChecker checker = new ModelChecker();
        try {
            checker.check("ExampleModel");
            System.out.println("Shard keys are continuous.");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}
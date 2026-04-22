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

        // Simulated shard key index check (for demonstration purposes)
        int[] shardKeys = {0, 1, 2, 4}; // Example shard keys, notice 3 is missing
        for (int i = 0; i < shardKeys.length - 1; i++) {
            if (shardKeys[i] + 1 != shardKeys[i + 1]) {
                throw new IllegalStateException("Shard key indices are not continuous");
            }
        }
    }

    public static void main(String[] args) {
        ModelChecker checker = new ModelChecker();
        try {
            checker.check("ExampleModel");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
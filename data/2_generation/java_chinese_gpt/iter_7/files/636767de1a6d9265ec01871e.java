public class ModelChecker {

    /**
     * @param modelName 实体的模型名称
     * @throws IllegalStateException 如果分片键索引不连续
     */
    private void check(String modelName) throws IllegalStateException {
        // Example logic to check for continuity of shard key indices
        // This is a placeholder for the actual implementation
        int[] shardKeyIndices = getShardKeyIndices(modelName);
        
        for (int i = 0; i < shardKeyIndices.length - 1; i++) {
            if (shardKeyIndices[i] + 1 != shardKeyIndices[i + 1]) {
                throw new IllegalStateException("分片键索引不连续: " + modelName);
            }
        }
    }

    // Placeholder method to simulate fetching shard key indices
    private int[] getShardKeyIndices(String modelName) {
        // This should return the actual shard key indices based on the modelName
        return new int[]{0, 1, 2}; // Example continuous indices
    }

    public static void main(String[] args) {
        ModelChecker checker = new ModelChecker();
        try {
            checker.check("exampleModel");
            System.out.println("检查通过");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}
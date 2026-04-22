public class ShardingKeyChecker {

    /**
     * @param modelName model name of the entity
     * @throws IllegalStateException if sharding key indices are not continuous
     */
    private void check(String modelName) throws IllegalStateException {
        // Example implementation of checking sharding key indices
        int[] shardingKeyIndices = getShardingKeyIndices(modelName);
        
        for (int i = 0; i < shardingKeyIndices.length - 1; i++) {
            if (shardingKeyIndices[i] + 1 != shardingKeyIndices[i + 1]) {
                throw new IllegalStateException("Sharding key indices are not continuous for model: " + modelName);
            }
        }
    }

    // Mock method to simulate retrieval of sharding key indices
    private int[] getShardingKeyIndices(String modelName) {
        // This should return the actual sharding key indices based on the modelName
        // For demonstration, returning a sample array
        return new int[]{0, 1, 2, 4}; // Example of non-continuous indices
    }

    public static void main(String[] args) {
        ShardingKeyChecker checker = new ShardingKeyChecker();
        try {
            checker.check("SampleModel");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
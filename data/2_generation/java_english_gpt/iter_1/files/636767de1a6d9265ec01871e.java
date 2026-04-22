public class ShardingKeyChecker {

    /**
     * @param modelName model name of the entity
     * @throws IllegalStateException if sharding key indices are not continuous
     */
    private void check(String modelName) throws IllegalStateException {
        // Example sharding key indices for demonstration
        int[] shardingKeyIndices = {0, 1, 2, 4}; // Non-continuous example

        // Check for continuity
        for (int i = 0; i < shardingKeyIndices.length - 1; i++) {
            if (shardingKeyIndices[i] + 1 != shardingKeyIndices[i + 1]) {
                throw new IllegalStateException("Sharding key indices are not continuous for model: " + modelName);
            }
        }
    }

    public static void main(String[] args) {
        ShardingKeyChecker checker = new ShardingKeyChecker();
        try {
            checker.check("ExampleModel");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
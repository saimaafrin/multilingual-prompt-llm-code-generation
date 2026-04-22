public class ShardingChecker {

    /**
     * @param modelName nome del modello dell'entità
     * @throws IllegalStateException se gli indici della chiave di sharding non sono continui
     */
    private void check(String modelName) throws IllegalStateException {
        // Simulated logic for checking sharding key indices
        int[] shardingKeyIndices = getShardingKeyIndices(modelName);
        
        for (int i = 0; i < shardingKeyIndices.length - 1; i++) {
            if (shardingKeyIndices[i] + 1 != shardingKeyIndices[i + 1]) {
                throw new IllegalStateException("Sharding key indices are not continuous for model: " + modelName);
            }
        }
    }

    // Simulated method to retrieve sharding key indices based on model name
    private int[] getShardingKeyIndices(String modelName) {
        // This is just a placeholder. In a real implementation, this would fetch the actual indices.
        return new int[]{0, 1, 2}; // Example of continuous indices
    }

    public static void main(String[] args) {
        ShardingChecker checker = new ShardingChecker();
        try {
            checker.check("ExampleModel");
            System.out.println("Sharding key indices are continuous.");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}
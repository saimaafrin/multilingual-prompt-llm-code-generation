public class ShardingChecker {

    /**
     * @param modelName nome del modello dell'entità
     * @throws IllegalStateException se gli indici della chiave di sharding non sono continui
     */
    private void check(String modelName) throws IllegalStateException {
        // Simulated sharding key indices for demonstration purposes
        int[] shardingKeyIndices = {0, 1, 2, 4}; // Example of non-continuous indices

        for (int i = 0; i < shardingKeyIndices.length - 1; i++) {
            if (shardingKeyIndices[i] + 1 != shardingKeyIndices[i + 1]) {
                throw new IllegalStateException("Sharding key indices are not continuous for model: " + modelName);
            }
        }
    }

    public static void main(String[] args) {
        ShardingChecker checker = new ShardingChecker();
        try {
            checker.check("ExampleModel");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
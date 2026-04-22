public class ShardingChecker {

    /**
     * @param modelName nombre del modelo de la entidad
     * @throws IllegalStateException si los índices de la clave de "sharding" no son continuos
     */
    private void check(String modelName) throws IllegalStateException {
        // Simulated logic for checking sharding keys
        int[] shardingKeys = getShardingKeys(modelName);
        
        for (int i = 0; i < shardingKeys.length - 1; i++) {
            if (shardingKeys[i] + 1 != shardingKeys[i + 1]) {
                throw new IllegalStateException("Los índices de la clave de sharding no son continuos para el modelo: " + modelName);
            }
        }
    }

    // Simulated method to retrieve sharding keys for a given model name
    private int[] getShardingKeys(String modelName) {
        // This is just a placeholder. In a real implementation, this would fetch the actual sharding keys.
        return new int[]{1, 2, 3}; // Example of continuous keys
        // return new int[]{1, 3}; // Example of non-continuous keys (uncomment to test exception)
    }

    public static void main(String[] args) {
        ShardingChecker checker = new ShardingChecker();
        try {
            checker.check("ExampleModel");
            System.out.println("Sharding keys are continuous.");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}
public class ShardingChecker {

    /**
     * @param modelName nombre del modelo de la entidad
     * @throws IllegalStateException si los índices de la clave de "sharding" no son continuos
     */
    private void check(String modelName) throws IllegalStateException {
        // Simulated logic for checking sharding indices
        int[] shardingIndices = getShardingIndices(modelName);
        
        for (int i = 0; i < shardingIndices.length - 1; i++) {
            if (shardingIndices[i] + 1 != shardingIndices[i + 1]) {
                throw new IllegalStateException("Los índices de la clave de sharding no son continuos para el modelo: " + modelName);
            }
        }
    }

    // Simulated method to get sharding indices for a model
    private int[] getShardingIndices(String modelName) {
        // This is just a placeholder. In a real implementation, this would fetch actual sharding indices.
        return new int[]{0, 1, 2}; // Example of continuous indices
    }

    public static void main(String[] args) {
        ShardingChecker checker = new ShardingChecker();
        try {
            checker.check("ExampleModel");
            System.out.println("Sharding indices are continuous.");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}
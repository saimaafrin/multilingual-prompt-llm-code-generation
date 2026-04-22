public class ShardingChecker {

    /**
     * @param modelName nombre del modelo de la entidad
     * @throws IllegalStateException si los índices de la clave de "sharding" no son continuos
     */
    private void check(String modelName) throws IllegalStateException {
        // Simulated sharding key indices for demonstration purposes
        int[] shardingKeyIndices = {0, 1, 2, 4}; // Example of non-continuous indices

        for (int i = 0; i < shardingKeyIndices.length - 1; i++) {
            if (shardingKeyIndices[i] + 1 != shardingKeyIndices[i + 1]) {
                throw new IllegalStateException("Los índices de la clave de sharding no son continuos para el modelo: " + modelName);
            }
        }
    }

    public static void main(String[] args) {
        ShardingChecker checker = new ShardingChecker();
        try {
            checker.check("MyModel");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
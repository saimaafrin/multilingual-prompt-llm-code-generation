private void check(String modelName) throws IllegalStateException {
    // Example implementation of checking sharding key indices
    int[] shardingKeyIndices = getShardingKeyIndices(modelName); // Assume this method retrieves the indices
    for (int i = 0; i < shardingKeyIndices.length - 1; i++) {
        if (shardingKeyIndices[i] + 1 != shardingKeyIndices[i + 1]) {
            throw new IllegalStateException("Sharding key indices are not continuous for model: " + modelName);
        }
    }
}

// Mock method to simulate retrieval of sharding key indices
private int[] getShardingKeyIndices(String modelName) {
    // This is just a placeholder. In a real implementation, this would fetch actual indices.
    return new int[]{0, 1, 2, 4}; // Example of non-continuous indices
}
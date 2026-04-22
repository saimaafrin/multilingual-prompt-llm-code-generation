public class ShardingKeyChecker {

    /**
     * @param modelName एंटिटी का मॉडल नाम
     * @throws IllegalStateException यदि शार्डिंग कुंजी अनुक्रमांक निरंतर नहीं हैं
     */
    private void check(String modelName) throws IllegalStateException {
        // Example logic to check if sharding keys are continuous
        // This is a placeholder for the actual implementation
        int[] shardingKeys = getShardingKeys(modelName); // Assume this method retrieves sharding keys
        
        for (int i = 0; i < shardingKeys.length - 1; i++) {
            if (shardingKeys[i] + 1 != shardingKeys[i + 1]) {
                throw new IllegalStateException("Sharding keys are not continuous for model: " + modelName);
            }
        }
    }

    // Placeholder method to simulate retrieval of sharding keys
    private int[] getShardingKeys(String modelName) {
        // This should return the actual sharding keys based on the modelName
        return new int[]{1, 2, 3, 4}; // Example continuous keys
    }

    public static void main(String[] args) {
        ShardingKeyChecker checker = new ShardingKeyChecker();
        try {
            checker.check("ExampleModel");
            System.out.println("Sharding keys are continuous.");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}
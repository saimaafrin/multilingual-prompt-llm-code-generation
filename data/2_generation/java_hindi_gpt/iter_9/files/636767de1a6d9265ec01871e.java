public class ShardingKeyChecker {

    /**
     * @param modelName एंटिटी का मॉडल नाम
     * @throws IllegalStateException यदि शार्डिंग कुंजी अनुक्रमांक निरंतर नहीं हैं
     */
    private void check(String modelName) throws IllegalStateException {
        // Dummy implementation for demonstration
        // In a real scenario, you would check the sharding keys for continuity
        boolean isShardingKeyContinuous = false; // This should be replaced with actual logic

        if (!isShardingKeyContinuous) {
            throw new IllegalStateException("शार्डिंग कुंजी अनुक्रमांक निरंतर नहीं हैं: " + modelName);
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
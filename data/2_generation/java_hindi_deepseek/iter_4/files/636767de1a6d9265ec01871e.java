import java.util.HashMap;
import java.util.Map;

public class ShardingChecker {

    private Map<String, Integer> shardingKeySequence = new HashMap<>();

    /**
     * @param modelName एंटिटी का मॉडल नाम
     * @throws IllegalStateException यदि शार्डिंग कुंजी अनुक्रमांक निरंतर नहीं हैं
     */
    private void check(String modelName) throws IllegalStateException {
        if (!shardingKeySequence.containsKey(modelName)) {
            throw new IllegalStateException("Sharding key sequence is not continuous for model: " + modelName);
        }

        int currentSequence = shardingKeySequence.get(modelName);
        int expectedSequence = getExpectedSequence(modelName);

        if (currentSequence != expectedSequence) {
            throw new IllegalStateException("Sharding key sequence is not continuous for model: " + modelName);
        }
    }

    private int getExpectedSequence(String modelName) {
        // This method should return the expected sequence number for the given model.
        // For the sake of this example, we assume it returns a fixed value.
        return 1; // Replace with actual logic to determine the expected sequence.
    }

    // Example usage
    public static void main(String[] args) {
        ShardingChecker checker = new ShardingChecker();
        checker.shardingKeySequence.put("exampleModel", 1);

        try {
            checker.check("exampleModel");
            System.out.println("Sharding key sequence is continuous.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
import java.util.HashMap;
import java.util.Map;

public class ShardingKeyChecker {

    private Map<String, Integer> shardingKeyMap = new HashMap<>();

    /**
     * @param modelName एंटिटी का मॉडल नाम
     * @throws IllegalStateException यदि शार्डिंग कुंजी अनुक्रमांक निरंतर नहीं हैं
     */
    private void check(String modelName) throws IllegalStateException {
        if (!shardingKeyMap.containsKey(modelName)) {
            throw new IllegalStateException("Sharding key for model " + modelName + " does not exist.");
        }

        int currentKey = shardingKeyMap.get(modelName);
        int expectedKey = shardingKeyMap.size() + 1;

        if (currentKey != expectedKey) {
            throw new IllegalStateException("Sharding keys are not sequential for model " + modelName);
        }
    }

    // Example usage
    public static void main(String[] args) {
        ShardingKeyChecker checker = new ShardingKeyChecker();
        checker.shardingKeyMap.put("Model1", 1);
        checker.shardingKeyMap.put("Model2", 2);

        try {
            checker.check("Model1");
            checker.check("Model2");
            System.out.println("Sharding keys are sequential.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
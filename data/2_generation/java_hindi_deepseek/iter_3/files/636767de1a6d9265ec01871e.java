import java.util.HashMap;
import java.util.Map;

public class ShardingKeyChecker {

    private Map<String, Integer> shardingKeyMap;

    public ShardingKeyChecker() {
        shardingKeyMap = new HashMap<>();
        // Initialize with some example data
        shardingKeyMap.put("model1", 1);
        shardingKeyMap.put("model2", 2);
        shardingKeyMap.put("model3", 3);
    }

    /**
     * @param modelName एंटिटी का मॉडल नाम
     * @throws IllegalStateException यदि शार्डिंग कुंजी अनुक्रमांक निरंतर नहीं हैं
     */
    private void check(String modelName) throws IllegalStateException {
        if (!shardingKeyMap.containsKey(modelName)) {
            throw new IllegalStateException("Model name not found in sharding key map.");
        }

        int currentKey = shardingKeyMap.get(modelName);
        int previousKey = currentKey - 1;

        if (!shardingKeyMap.containsValue(previousKey)) {
            throw new IllegalStateException("Sharding key sequence is not continuous.");
        }
    }

    public static void main(String[] args) {
        ShardingKeyChecker checker = new ShardingKeyChecker();
        try {
            checker.check("model2");
            System.out.println("Sharding key sequence is continuous.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
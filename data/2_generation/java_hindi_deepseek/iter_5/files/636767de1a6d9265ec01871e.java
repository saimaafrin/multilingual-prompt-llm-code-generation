import java.util.HashMap;
import java.util.Map;

public class ShardingKeyChecker {

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
        int expectedSequence = shardingKeySequence.size() + 1;

        if (currentSequence != expectedSequence) {
            throw new IllegalStateException("Sharding key sequence is not continuous for model: " + modelName);
        }

        shardingKeySequence.put(modelName, expectedSequence);
    }

    public static void main(String[] args) {
        ShardingKeyChecker checker = new ShardingKeyChecker();
        checker.shardingKeySequence.put("Model1", 1);
        checker.shardingKeySequence.put("Model2", 2);

        try {
            checker.check("Model3");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
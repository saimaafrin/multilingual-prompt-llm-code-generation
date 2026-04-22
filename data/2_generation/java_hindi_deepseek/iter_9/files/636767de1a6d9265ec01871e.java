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
            shardingKeySequence.put(modelName, 0);
        } else {
            int currentSequence = shardingKeySequence.get(modelName);
            if (currentSequence != shardingKeySequence.size() - 1) {
                throw new IllegalStateException("शार्डिंग कुंजी अनुक्रमांक निरंतर नहीं हैं");
            }
            shardingKeySequence.put(modelName, currentSequence + 1);
        }
    }
}
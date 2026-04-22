import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MappingUtils {

    /**
     * Returns mappings with fields that not exist in the input mappings. The input mappings should be history mapping from current index. 
     * Do not return _source config to avoid current index update conflict.
     * @param currentMappings The current index mappings
     * @param historyMappings The history mappings to compare against
     * @return Map containing only new/different mappings
     */
    public Map<String, Object> getDifferenceMappings(Map<String, Object> currentMappings, Map<String, Object> historyMappings) {
        // Create new map to store differences
        Map<String, Object> differenceMappings = new HashMap<>();

        // If either mapping is null/empty, return empty map
        if (currentMappings == null || historyMappings == null) {
            return differenceMappings;
        }

        // Iterate through current mappings
        for (Map.Entry<String, Object> entry : currentMappings.entrySet()) {
            String key = entry.getKey();
            Object currentValue = entry.getValue();

            // Skip _source field
            if ("_source".equals(key)) {
                continue;
            }

            // If key doesn't exist in history or values are different, add to difference map
            if (!historyMappings.containsKey(key)) {
                differenceMappings.put(key, currentValue);
            } else {
                Object historyValue = historyMappings.get(key);
                
                // Recursively check nested mappings
                if (currentValue instanceof Map && historyValue instanceof Map) {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> nestedDiff = getDifferenceMappings(
                        (Map<String, Object>) currentValue,
                        (Map<String, Object>) historyValue
                    );
                    
                    if (!nestedDiff.isEmpty()) {
                        differenceMappings.put(key, nestedDiff);
                    }
                } else if (!currentValue.equals(historyValue)) {
                    differenceMappings.put(key, currentValue);
                }
            }
        }

        return differenceMappings;
    }
}
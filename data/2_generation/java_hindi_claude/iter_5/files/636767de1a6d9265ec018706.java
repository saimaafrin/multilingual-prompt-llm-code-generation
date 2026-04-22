import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MappingUtils {

    /**
     * Returns mappings with fields that not exist in the input mappings. The input mappings should be history mapping from current index. 
     * Do not return _source config to avoid current index update conflict.
     * @param currentMappings The current index mappings
     * @param historyMappings The history mappings to compare against
     * @return Map containing only new fields not present in history mappings
     */
    public Map<String, Object> getDiffMappings(Map<String, Object> currentMappings, Map<String, Object> historyMappings) {
        Map<String, Object> diffMappings = new HashMap<>();
        
        // Handle null inputs
        if (currentMappings == null || historyMappings == null) {
            return diffMappings;
        }

        // Iterate through current mappings
        for (Map.Entry<String, Object> entry : currentMappings.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            // Skip _source config
            if ("_source".equals(key)) {
                continue;
            }

            // If key doesn't exist in history mappings, add it
            if (!historyMappings.containsKey(key)) {
                diffMappings.put(key, value);
                continue;
            }

            // If value is a nested map, recursively check differences
            if (value instanceof Map && historyMappings.get(key) instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> nestedDiff = getDiffMappings(
                    (Map<String, Object>) value,
                    (Map<String, Object>) historyMappings.get(key)
                );
                
                if (!nestedDiff.isEmpty()) {
                    diffMappings.put(key, nestedDiff);
                }
            }
            // If values are different, add to diff
            else if (!value.equals(historyMappings.get(key))) {
                diffMappings.put(key, value);
            }
        }

        return diffMappings;
    }
}
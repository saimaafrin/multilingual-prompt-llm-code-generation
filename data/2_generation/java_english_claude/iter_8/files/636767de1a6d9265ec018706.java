import org.elasticsearch.cluster.metadata.MappingMetadata;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.mapper.MapperService;
import org.elasticsearch.index.mapper.Mapping;
import org.elasticsearch.index.mapper.Mappings;
import java.util.HashMap;
import java.util.Map;

public class MappingDiffer {

    public Mappings diffStructure(String tableName, Mappings mappings) {
        if (mappings == null) {
            return null;
        }

        // Get the properties from input mappings
        Map<String, Object> inputProperties = mappings.getSourceAsMap();
        
        // Create new map for storing diff properties
        Map<String, Object> diffProperties = new HashMap<>();

        // Get current index mappings
        Map<String, Object> currentProperties = getCurrentIndexMappings(tableName);

        // Compare and find fields that don't exist in current mappings
        for (Map.Entry<String, Object> entry : inputProperties.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            // Skip _source field
            if ("_source".equals(field)) {
                continue;
            }

            // Add field to diff if it doesn't exist in current mappings
            if (!currentProperties.containsKey(field)) {
                diffProperties.put(field, value);
            } else {
                // For nested objects, recursively check differences
                if (value instanceof Map && currentProperties.get(field) instanceof Map) {
                    Map<String, Object> nestedDiff = compareNestedMappings(
                            (Map<String, Object>) value,
                            (Map<String, Object>) currentProperties.get(field)
                    );
                    if (!nestedDiff.isEmpty()) {
                        diffProperties.put(field, nestedDiff);
                    }
                }
            }
        }

        // Create new Mappings object with diff properties
        if (diffProperties.isEmpty()) {
            return null;
        }

        return new Mappings.Builder()
                .putAll(diffProperties)
                .build();
    }

    private Map<String, Object> getCurrentIndexMappings(String tableName) {
        // Implementation to get current index mappings
        // This would typically involve calling Elasticsearch API
        return new HashMap<>();
    }

    private Map<String, Object> compareNestedMappings(
            Map<String, Object> inputMap,
            Map<String, Object> currentMap) {
        Map<String, Object> diffMap = new HashMap<>();

        for (Map.Entry<String, Object> entry : inputMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (!currentMap.containsKey(key)) {
                diffMap.put(key, value);
            } else if (value instanceof Map && currentMap.get(key) instanceof Map) {
                Map<String, Object> nestedDiff = compareNestedMappings(
                        (Map<String, Object>) value,
                        (Map<String, Object>) currentMap.get(key)
                );
                if (!nestedDiff.isEmpty()) {
                    diffMap.put(key, nestedDiff);
                }
            }
        }

        return diffMap;
    }
}
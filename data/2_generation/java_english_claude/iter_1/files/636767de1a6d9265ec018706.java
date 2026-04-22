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
        
        // Create new map for storing diff
        Map<String, Object> diffMap = new HashMap<>();
        
        // Get current index mappings
        Map<String, Object> currentMappings = getCurrentIndexMappings(tableName);
        
        if (currentMappings != null) {
            // Compare and get fields that don't exist in current mappings
            for (Map.Entry<String, Object> entry : inputProperties.entrySet()) {
                String field = entry.getKey();
                if (!currentMappings.containsKey(field)) {
                    diffMap.put(field, entry.getValue());
                }
            }
        } else {
            // If no current mappings exist, return all input mappings
            diffMap.putAll(inputProperties);
        }
        
        // Remove _source from diff to avoid conflicts
        diffMap.remove("_source");
        
        // Create new Mappings object with diff
        return new Mappings.Builder()
                .putAll(diffMap)
                .build();
    }
    
    // Helper method to get current index mappings
    private Map<String, Object> getCurrentIndexMappings(String tableName) {
        try {
            // This would need to be implemented based on your specific ES client setup
            // Example implementation:
            GetMappingsRequest request = new GetMappingsRequest().indices(tableName);
            GetMappingsResponse response = client.indices().getMapping(request, RequestOptions.DEFAULT);
            MappingMetadata mappingMetadata = response.mappings().get(tableName);
            
            if (mappingMetadata != null) {
                return mappingMetadata.sourceAsMap();
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get current index mappings", e);
        }
    }
}
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
        
        // Get current mappings for table
        Mappings currentMappings = getCurrentMappings(tableName);
        if (currentMappings != null) {
            Map<String, Object> currentProperties = currentMappings.getSourceAsMap();
            
            // Compare and add fields that don't exist in current mappings
            for (Map.Entry<String, Object> entry : inputProperties.entrySet()) {
                String field = entry.getKey();
                if (!currentProperties.containsKey(field)) {
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
        return new Mappings(MapperService.SINGLE_MAPPING_NAME, diffMap);
    }
    
    // Helper method to get current mappings for a table
    private Mappings getCurrentMappings(String tableName) {
        try {
            MappingMetadata mappingMetadata = getClient().admin().indices()
                .prepareGetMappings(tableName)
                .get()
                .getMappings()
                .get(tableName);
                
            if (mappingMetadata != null) {
                return new Mappings(MapperService.SINGLE_MAPPING_NAME, mappingMetadata.getSourceAsMap());
            }
        } catch (Exception e) {
            // Handle exceptions
        }
        return null;
    }
}
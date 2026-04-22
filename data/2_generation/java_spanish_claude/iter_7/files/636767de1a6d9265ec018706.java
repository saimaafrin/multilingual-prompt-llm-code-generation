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
        
        // Get current index mappings
        Map<String, Object> currentMappings = getCurrentIndexMappings(tableName);
        
        // Create new mappings object to store the diff
        Map<String, Object> diffMappings = new HashMap<>();
        
        // Compare and get fields that don't exist in current mappings
        for (Map.Entry<String, Object> entry : inputProperties.entrySet()) {
            String field = entry.getKey();
            
            // Skip _source field
            if ("_source".equals(field)) {
                continue;
            }
            
            if (!currentMappings.containsKey(field)) {
                diffMappings.put(field, entry.getValue());
            }
        }
        
        // Create new Mappings object with diff
        return new Mappings(
            MapperService.SINGLE_MAPPING_NAME,
            diffMappings
        );
    }
    
    // Helper method to get current index mappings
    private Map<String, Object> getCurrentIndexMappings(String indexName) {
        try {
            MappingMetadata mappingMetadata = client.admin()
                .indices()
                .prepareGetMappings(indexName)
                .get()
                .getMappings()
                .get(indexName);
                
            if (mappingMetadata != null) {
                return mappingMetadata.getSourceAsMap();
            }
            
            return new HashMap<>();
            
        } catch (Exception e) {
            throw new RuntimeException("Error getting current index mappings", e);
        }
    }
    
    private final Client client;
    
    public MappingDiffer(Client client) {
        this.client = client;
    }
}
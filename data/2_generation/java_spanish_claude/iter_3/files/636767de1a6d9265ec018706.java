import org.elasticsearch.cluster.metadata.MappingMetadata;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.mapper.MapperService;
import org.elasticsearch.index.mapper.Mapping;
import org.elasticsearch.index.mapper.Mappings;

public class MappingDiffer {

    public Mappings diffStructure(String tableName, Mappings mappings) {
        try {
            // Create empty mappings builder
            Mappings.Builder diffMappings = new Mappings.Builder();

            // Get current index mappings
            ImmutableOpenMap<String, MappingMetadata> currentMappings = getCurrentIndexMappings(tableName);
            
            // Get properties from input mappings
            Map<String, Object> inputProperties = mappings.getSourceAsMap();
            
            // Iterate through input mappings and find fields that don't exist in current
            for (Map.Entry<String, Object> entry : inputProperties.entrySet()) {
                String fieldName = entry.getKey();
                
                // Skip _source field
                if (fieldName.equals("_source")) {
                    continue;
                }
                
                // If field doesn't exist in current mappings, add to diff
                if (!currentMappings.containsKey(fieldName)) {
                    diffMappings.put(fieldName, entry.getValue());
                }
            }

            return diffMappings.build();

        } catch (Exception e) {
            throw new RuntimeException("Error diffing mappings structure", e);
        }
    }

    // Helper method to get current index mappings
    private ImmutableOpenMap<String, MappingMetadata> getCurrentIndexMappings(String indexName) {
        try {
            GetMappingsRequest request = new GetMappingsRequest().indices(indexName);
            GetMappingsResponse response = client.admin().indices().getMappings(request).actionGet();
            return response.getMappings().get(indexName).getMappings();
        } catch (Exception e) {
            throw new RuntimeException("Error getting current mappings", e);
        }
    }
}
import org.elasticsearch.cluster.metadata.MappingMetadata;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.mapper.MapperService;
import org.elasticsearch.index.mapper.Mapping;
import org.elasticsearch.index.mapper.Mappings;

public class MappingDiffer {

    public Mappings diffStructure(String tableName, Mappings mappings) {
        if (mappings == null) {
            return null;
        }

        // Create new mappings builder
        Mappings.Builder diffMappings = new Mappings.Builder();

        // Get properties from input mappings
        Map<String, Object> properties = mappings.getSourceAsMap();
        if (properties == null || properties.isEmpty()) {
            return null;
        }

        // Get current index mappings
        ImmutableOpenMap<String, MappingMetadata> currentMappings = getCurrentIndexMappings(tableName);
        
        // Compare and add fields that don't exist in current mappings
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String fieldName = entry.getKey();
            
            if (!fieldExists(fieldName, currentMappings)) {
                // Add field to diff mappings
                diffMappings.field(fieldName, entry.getValue());
            }
        }

        // Remove _source field to avoid conflicts
        diffMappings.removeField("_source");

        return diffMappings.build();
    }

    private ImmutableOpenMap<String, MappingMetadata> getCurrentIndexMappings(String indexName) {
        try {
            GetMappingsRequest request = new GetMappingsRequest().indices(indexName);
            GetMappingsResponse response = client.admin().indices().getMappings(request).actionGet();
            return response.getMappings().get(indexName);
        } catch (Exception e) {
            return ImmutableOpenMap.of();
        }
    }

    private boolean fieldExists(String fieldName, ImmutableOpenMap<String, MappingMetadata> currentMappings) {
        try {
            for (ObjectObjectCursor<String, MappingMetadata> cursor : currentMappings) {
                Map<String, Object> sourceMap = cursor.value.getSourceAsMap();
                if (sourceMap.containsKey(fieldName)) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
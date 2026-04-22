import org.elasticsearch.cluster.metadata.MappingMetadata;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.mapper.MapperService;
import org.elasticsearch.index.mapper.Mapping;
import org.elasticsearch.index.mapper.Mappings;

public class MappingDiffer {

    public Mappings diffStructure(String tableName, Mappings mappings) {
        try {
            // Create empty mappings to store the diff
            Mappings diffMappings = new Mappings.Builder().build();
            
            if (mappings == null) {
                return diffMappings;
            }

            // Get the properties from input mappings
            Map<String, Object> properties = mappings.getSourceAsMap();
            if (properties == null || properties.isEmpty()) {
                return diffMappings;
            }

            // Get current index mappings
            GetMappingsRequest request = new GetMappingsRequest().indices(tableName);
            GetMappingsResponse currentMappings = client.admin().indices()
                    .getMappings(request)
                    .actionGet();

            // Extract current mappings for the table
            ImmutableOpenMap<String, MappingMetadata> currentMap = 
                    currentMappings.getMappings().get(tableName);
            
            if (currentMap == null || currentMap.isEmpty()) {
                return mappings; // Return all mappings if table doesn't exist
            }

            MappingMetadata metadata = currentMap.get(tableName);
            Map<String, Object> currentProperties = 
                    (Map<String, Object>) metadata.getSourceAsMap().get("properties");

            // Build diff mappings
            Map<String, Object> diffProperties = new HashMap<>();
            
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String field = entry.getKey();
                if (!currentProperties.containsKey(field)) {
                    diffProperties.put(field, entry.getValue());
                }
            }

            // Create new mappings with only the diff
            if (!diffProperties.isEmpty()) {
                Map<String, Object> diffMap = new HashMap<>();
                diffMap.put("properties", diffProperties);
                
                diffMappings = new Mappings.Builder()
                        .source(diffMap)
                        .build();
            }

            return diffMappings;

        } catch (Exception e) {
            throw new RuntimeException("Error calculating mapping differences", e);
        }
    }
}
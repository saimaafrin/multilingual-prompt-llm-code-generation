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

        // Create new mappings object to store differences
        Mappings diffMappings = new Mappings(MapperService.SINGLE_MAPPING_NAME);

        // Get properties from input mappings
        Map<String, Object> sourceProps = mappings.getSourceAsMap();
        if (sourceProps == null || sourceProps.isEmpty()) {
            return diffMappings;
        }

        // Get current index mappings
        Map<String, Object> currentProps = getCurrentIndexMappings(tableName);
        
        // Compare and add fields that don't exist in current mappings
        Map<String, Object> diffProps = new HashMap<>();
        compareProperties(sourceProps, currentProps, diffProps);

        // Build new mappings excluding _source
        if (!diffProps.isEmpty()) {
            Map<String, Object> properties = new HashMap<>();
            properties.put("properties", diffProps);
            diffMappings.sourceAsMap().putAll(properties);
        }

        return diffMappings;
    }

    private Map<String, Object> getCurrentIndexMappings(String tableName) {
        try {
            GetMappingsRequest request = new GetMappingsRequest().indices(tableName);
            GetMappingsResponse response = client.admin().indices().getMappings(request).actionGet();
            ImmutableOpenMap<String, MappingMetadata> mappings = response.getMappings();
            MappingMetadata mapping = mappings.get(tableName);
            if (mapping != null) {
                return mapping.getSourceAsMap();
            }
        } catch (Exception e) {
            // Handle exception
        }
        return new HashMap<>();
    }

    private void compareProperties(Map<String, Object> source, Map<String, Object> current, 
                                 Map<String, Object> diff) {
        for (Map.Entry<String, Object> entry : source.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (!current.containsKey(key)) {
                diff.put(key, value);
            } else if (value instanceof Map) {
                Map<String, Object> sourceNested = (Map<String, Object>) value;
                Map<String, Object> currentNested = (Map<String, Object>) current.get(key);
                Map<String, Object> diffNested = new HashMap<>();
                
                compareProperties(sourceNested, currentNested, diffNested);
                
                if (!diffNested.isEmpty()) {
                    diff.put(key, diffNested); 
                }
            }
        }
    }
}
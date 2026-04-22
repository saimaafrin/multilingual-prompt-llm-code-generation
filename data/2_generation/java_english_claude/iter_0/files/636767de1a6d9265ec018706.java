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
        Map<String, Object> sourceMap = mappings.getSourceAsMap();
        if (sourceMap == null || !sourceMap.containsKey("properties")) {
            return null;
        }

        // Create new mapping without _source
        Map<String, Object> newMappings = new HashMap<>();
        Map<String, Object> properties = new HashMap<>();
        
        // Copy properties excluding _source
        Map<String, Object> inputProperties = (Map<String, Object>) sourceMap.get("properties");
        for (Map.Entry<String, Object> entry : inputProperties.entrySet()) {
            String fieldName = entry.getKey();
            if (!fieldName.equals("_source")) {
                properties.put(fieldName, entry.getValue());
            }
        }

        // Build new mapping structure
        newMappings.put("properties", properties);
        
        // Create new Mappings object
        return new Mappings(
            MapperService.SINGLE_MAPPING_NAME,
            newMappings
        );
    }
}
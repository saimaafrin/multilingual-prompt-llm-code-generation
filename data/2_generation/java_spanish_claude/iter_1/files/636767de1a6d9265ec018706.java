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
            ImmutableOpenMap<String, MappingMetadata> currentMappings = mappings.getMappings();
            
            if (currentMappings == null || currentMappings.isEmpty()) {
                return null;
            }

            // Get mapping for table
            MappingMetadata tableMapping = currentMappings.get(tableName);
            if (tableMapping == null) {
                return null;
            }

            // Get properties map
            Map<String, Object> properties = (Map<String, Object>) tableMapping.getSourceAsMap().get("properties");
            
            if (properties == null) {
                return null;
            }

            // Create new mapping without _source
            Map<String, Object> newMapping = new HashMap<>();
            newMapping.put("properties", properties);

            // Remove _source configuration
            newMapping.remove("_source");

            // Build new mappings object
            diffMappings.put(tableName, newMapping);

            return diffMappings.build();

        } catch (Exception e) {
            throw new RuntimeException("Error diffing mappings structure", e);
        }
    }
}
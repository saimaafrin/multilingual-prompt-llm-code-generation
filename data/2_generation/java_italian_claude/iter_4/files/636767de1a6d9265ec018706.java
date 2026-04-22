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
                .getMappings(request).actionGet();
            
            ImmutableOpenMap<String, MappingMetadata> indexMappings = 
                currentMappings.getMappings().get(tableName);

            if (indexMappings == null || indexMappings.isEmpty()) {
                // If no current mappings exist, return input mappings without _source
                Map<String, Object> cleanProperties = new HashMap<>(properties);
                cleanProperties.remove("_source");
                return new Mappings.Builder().sourceAsMap(cleanProperties).build();
            }

            // Compare and build diff mappings
            Map<String, Object> diffProperties = new HashMap<>();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String field = entry.getKey();
                if (!indexMappings.containsKey(field) && !field.equals("_source")) {
                    diffProperties.put(field, entry.getValue());
                }
            }

            return new Mappings.Builder().sourceAsMap(diffProperties).build();

        } catch (Exception e) {
            throw new RuntimeException("Error calculating mapping differences", e);
        }
    }
}
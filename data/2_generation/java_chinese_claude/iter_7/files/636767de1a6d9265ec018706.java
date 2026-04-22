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
        Map<String, Object> properties = mappings.getSourceAsMap();
        if (properties == null || properties.isEmpty()) {
            return null;
        }

        // Create new mapping without _source
        Map<String, Object> newMappings = new HashMap<>();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String key = entry.getKey();
            if (!key.equals("_source")) {
                newMappings.put(key, entry.getValue());
            }
        }

        // Build and return new Mappings object
        try {
            return Mappings.fromMap(newMappings);
        } catch (Exception e) {
            return null;
        }
    }
}
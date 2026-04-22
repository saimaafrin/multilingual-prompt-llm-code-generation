import java.util.HashMap;
import java.util.Map;

public class Mappings {
    private Map<String, Object> properties;

    public Mappings() {
        this.properties = new HashMap<>();
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}

public class MappingDiff {

    /**
     * Returns mappings with fields that do not exist in the input mappings. The input mappings should be history mapping from current index. Do not return _source config to avoid current index update conflict.
     *
     * @param tableName The name of the table.
     * @param mappings The current mappings to compare against.
     * @return A new Mappings object containing only the fields that are not present in the input mappings.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        Mappings result = new Mappings();
        Map<String, Object> currentProperties = mappings.getProperties();
        Map<String, Object> newProperties = new HashMap<>();

        // Assuming the tableName is used to fetch the latest mappings from some source
        // For simplicity, let's assume we have a method to get the latest mappings
        Mappings latestMappings = getLatestMappings(tableName);

        if (latestMappings != null) {
            Map<String, Object> latestProperties = latestMappings.getProperties();

            for (Map.Entry<String, Object> entry : latestProperties.entrySet()) {
                if (!currentProperties.containsKey(entry.getKey())) {
                    newProperties.put(entry.getKey(), entry.getValue());
                }
            }
        }

        result.setProperties(newProperties);
        return result;
    }

    // Dummy method to simulate fetching the latest mappings
    private Mappings getLatestMappings(String tableName) {
        Mappings latestMappings = new Mappings();
        Map<String, Object> properties = new HashMap<>();
        properties.put("field1", "type1");
        properties.put("field2", "type2");
        latestMappings.setProperties(properties);
        return latestMappings;
    }
}
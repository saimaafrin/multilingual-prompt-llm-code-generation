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
     * Returns mappings with fields that do not exist in the input mappings. The input mappings should be history mapping from current index. 
     * Do not return _source config to avoid current index update conflict.
     *
     * @param tableName The name of the table.
     * @param mappings The current mappings to compare against.
     * @return A new Mappings object containing only the fields that are not present in the input mappings.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Assume we have a method to get the historical mappings for the table
        Mappings historicalMappings = getHistoricalMappings(tableName);

        Mappings result = new Mappings();
        Map<String, Object> resultProperties = new HashMap<>();

        // Iterate through the current mappings properties
        for (Map.Entry<String, Object> entry : mappings.getProperties().entrySet()) {
            String fieldName = entry.getKey();
            Object fieldConfig = entry.getValue();

            // Check if the field exists in the historical mappings
            if (!historicalMappings.getProperties().containsKey(fieldName)) {
                resultProperties.put(fieldName, fieldConfig);
            }
        }

        result.setProperties(resultProperties);
        return result;
    }

    // Dummy method to simulate fetching historical mappings
    private Mappings getHistoricalMappings(String tableName) {
        // In a real implementation, this would fetch the historical mappings from a data source
        Mappings historicalMappings = new Mappings();
        Map<String, Object> historicalProperties = new HashMap<>();
        // Example historical mappings
        historicalProperties.put("oldField1", new HashMap<>());
        historicalProperties.put("oldField2", new HashMap<>());
        historicalMappings.setProperties(historicalProperties);
        return historicalMappings;
    }
}
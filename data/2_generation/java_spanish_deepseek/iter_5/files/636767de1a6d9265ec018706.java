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

    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Assuming that the current index mappings are stored in a static or external source
        // For this example, we'll create a mock current index mappings
        Mappings currentIndexMappings = getCurrentIndexMappings(tableName);

        Mappings diffMappings = new Mappings();
        Map<String, Object> diffProperties = new HashMap<>();

        // Iterate through the input mappings and compare with current index mappings
        for (Map.Entry<String, Object> entry : mappings.getProperties().entrySet()) {
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();

            // Skip the _source configuration
            if ("_source".equals(fieldName)) {
                continue;
            }

            // Check if the field exists in the current index mappings
            if (!currentIndexMappings.getProperties().containsKey(fieldName)) {
                diffProperties.put(fieldName, fieldValue);
            }
        }

        diffMappings.setProperties(diffProperties);
        return diffMappings;
    }

    private Mappings getCurrentIndexMappings(String tableName) {
        // Mock implementation to return current index mappings
        Mappings currentMappings = new Mappings();
        Map<String, Object> currentProperties = new HashMap<>();
        currentProperties.put("existingField1", "type1");
        currentProperties.put("existingField2", "type2");
        currentMappings.setProperties(currentProperties);
        return currentMappings;
    }
}
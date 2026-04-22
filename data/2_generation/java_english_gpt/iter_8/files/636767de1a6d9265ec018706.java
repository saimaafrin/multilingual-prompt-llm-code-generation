import java.util.HashMap;
import java.util.Map;

public class MappingDiffer {
    
    /**
     * Returns mappings with fields that not exist in the input mappings. The input mappings should be history mapping from current index. Do not return _source config to avoid current index update conflict.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Assuming Mappings is a class that holds a map of field names to their configurations
        Mappings historyMappings = getHistoryMappings(tableName);
        Mappings diffMappings = new Mappings();

        for (Map.Entry<String, FieldConfig> entry : historyMappings.getFields().entrySet()) {
            String fieldName = entry.getKey();
            if (!mappings.getFields().containsKey(fieldName)) {
                diffMappings.addField(fieldName, entry.getValue());
            }
        }

        return diffMappings;
    }

    private Mappings getHistoryMappings(String tableName) {
        // This method should retrieve the historical mappings for the given table name
        // For the sake of this example, we will return an empty Mappings object
        return new Mappings();
    }

    // Assuming FieldConfig is a class that represents the configuration of a field
    public static class Mappings {
        private Map<String, FieldConfig> fields = new HashMap<>();

        public Map<String, FieldConfig> getFields() {
            return fields;
        }

        public void addField(String fieldName, FieldConfig fieldConfig) {
            fields.put(fieldName, fieldConfig);
        }
    }

    public static class FieldConfig {
        // Field configuration details go here
    }
}
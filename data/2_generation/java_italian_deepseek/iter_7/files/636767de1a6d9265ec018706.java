import java.util.HashMap;
import java.util.Map;

public class Mappings {
    private Map<String, Object> fields;

    public Mappings() {
        this.fields = new HashMap<>();
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }
}

public class MappingDiff {

    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Assuming that the historical mappings for the table are stored in a static map
        // This is just a placeholder for the actual historical mappings retrieval logic
        Map<String, Mappings> historicalMappings = getHistoricalMappings();

        Mappings historicalMapping = historicalMappings.get(tableName);
        if (historicalMapping == null) {
            return mappings; // If no historical mapping exists, return the current mappings
        }

        Mappings diffMappings = new Mappings();
        Map<String, Object> currentFields = mappings.getFields();
        Map<String, Object> historicalFields = historicalMapping.getFields();

        for (Map.Entry<String, Object> entry : currentFields.entrySet()) {
            String fieldName = entry.getKey();
            if (!historicalFields.containsKey(fieldName)) {
                diffMappings.getFields().put(fieldName, entry.getValue());
            }
        }

        return diffMappings;
    }

    private Map<String, Mappings> getHistoricalMappings() {
        // Placeholder for actual historical mappings retrieval logic
        // This should return a map of table names to their historical Mappings
        return new HashMap<>();
    }
}
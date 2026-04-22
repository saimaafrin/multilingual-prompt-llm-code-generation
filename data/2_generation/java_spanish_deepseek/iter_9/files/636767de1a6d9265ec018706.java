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
        // Assuming that the current index mappings are stored in a Map for simplicity
        Map<String, Object> currentMappings = getCurrentIndexMappings(tableName);

        Mappings diffMappings = new Mappings();
        Map<String, Object> diffProperties = new HashMap<>();

        for (Map.Entry<String, Object> entry : mappings.getProperties().entrySet()) {
            String fieldName = entry.getKey();
            if (!currentMappings.containsKey(fieldName)) {
                diffProperties.put(fieldName, entry.getValue());
            }
        }

        diffMappings.setProperties(diffProperties);
        return diffMappings;
    }

    private Map<String, Object> getCurrentIndexMappings(String tableName) {
        // This method should return the current index mappings for the given tableName
        // For the sake of this example, we return a hardcoded map
        Map<String, Object> currentMappings = new HashMap<>();
        currentMappings.put("existingField1", "type1");
        currentMappings.put("existingField2", "type2");
        return currentMappings;
    }

    public static void main(String[] args) {
        MappingDiff mappingDiff = new MappingDiff();

        Mappings inputMappings = new Mappings();
        Map<String, Object> inputProperties = new HashMap<>();
        inputProperties.put("existingField1", "type1");
        inputProperties.put("newField1", "type3");
        inputMappings.setProperties(inputProperties);

        Mappings diff = mappingDiff.diffStructure("exampleTable", inputMappings);

        System.out.println("Diff Mappings: " + diff.getProperties());
    }
}
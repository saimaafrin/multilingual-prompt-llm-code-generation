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
        // Assuming that the current index mappings are stored in a Map for comparison
        Map<String, Object> currentIndexMappings = getCurrentIndexMappings(tableName);

        Mappings diffMappings = new Mappings();
        Map<String, Object> diffProperties = new HashMap<>();

        for (Map.Entry<String, Object> entry : mappings.getProperties().entrySet()) {
            String fieldName = entry.getKey();
            Object fieldMapping = entry.getValue();

            if (!currentIndexMappings.containsKey(fieldName)) {
                diffProperties.put(fieldName, fieldMapping);
            }
        }

        diffMappings.setProperties(diffProperties);
        return diffMappings;
    }

    private Map<String, Object> getCurrentIndexMappings(String tableName) {
        // This method should retrieve the current index mappings for the given tableName
        // For the sake of this example, we return a hardcoded map
        Map<String, Object> currentMappings = new HashMap<>();
        currentMappings.put("existingField1", new HashMap<>());
        currentMappings.put("existingField2", new HashMap<>());
        return currentMappings;
    }

    public static void main(String[] args) {
        MappingDiff mappingDiff = new MappingDiff();

        Mappings inputMappings = new Mappings();
        Map<String, Object> inputProperties = new HashMap<>();
        inputProperties.put("newField1", new HashMap<>());
        inputProperties.put("existingField1", new HashMap<>());
        inputMappings.setProperties(inputProperties);

        Mappings diffMappings = mappingDiff.diffStructure("exampleTable", inputMappings);

        System.out.println("Diff Mappings: " + diffMappings.getProperties());
    }
}
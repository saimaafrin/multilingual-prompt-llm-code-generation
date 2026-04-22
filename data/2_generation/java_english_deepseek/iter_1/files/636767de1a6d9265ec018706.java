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
        // Assuming we have a method to get the current mappings for the table
        Mappings currentMappings = getCurrentMappings(tableName);

        Mappings diffMappings = new Mappings();
        Map<String, Object> currentProperties = currentMappings.getProperties();
        Map<String, Object> inputProperties = mappings.getProperties();

        // Iterate through the input mappings and find fields that do not exist in the current mappings
        for (Map.Entry<String, Object> entry : inputProperties.entrySet()) {
            String fieldName = entry.getKey();
            if (!currentProperties.containsKey(fieldName)) {
                diffMappings.getProperties().put(fieldName, entry.getValue());
            }
        }

        return diffMappings;
    }

    private Mappings getCurrentMappings(String tableName) {
        // This method should retrieve the current mappings for the given table
        // For the sake of this example, we'll return a dummy Mappings object
        Mappings currentMappings = new Mappings();
        Map<String, Object> properties = new HashMap<>();
        properties.put("existingField1", "type1");
        properties.put("existingField2", "type2");
        currentMappings.setProperties(properties);
        return currentMappings;
    }

    public static void main(String[] args) {
        MappingDiff mappingDiff = new MappingDiff();

        Mappings inputMappings = new Mappings();
        Map<String, Object> inputProperties = new HashMap<>();
        inputProperties.put("existingField1", "type1");
        inputProperties.put("newField1", "type3");
        inputMappings.setProperties(inputProperties);

        Mappings diffMappings = mappingDiff.diffStructure("exampleTable", inputMappings);

        // Output the diff mappings
        System.out.println("Diff Mappings: " + diffMappings.getProperties());
    }
}
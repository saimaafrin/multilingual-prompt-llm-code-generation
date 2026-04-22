import java.util.HashMap;
import java.util.Map;

public class Mappings {
    private Map<String, Object> fields;

    public Mappings() {
        this.fields = new HashMap<>();
    }

    public void addField(String fieldName, Object fieldValue) {
        fields.put(fieldName, fieldValue);
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public static Mappings diffStructure(String tableName, Mappings mappings) {
        // Simulated existing fields in the current index for the given tableName
        Map<String, Object> existingFields = getExistingFieldsForTable(tableName);
        
        Mappings diffMappings = new Mappings();
        
        for (String field : mappings.getFields().keySet()) {
            if (!existingFields.containsKey(field)) {
                diffMappings.addField(field, mappings.getFields().get(field));
            }
        }
        
        return diffMappings;
    }

    private static Map<String, Object> getExistingFieldsForTable(String tableName) {
        // This method should return the existing fields for the given tableName.
        // For demonstration purposes, we will return a static map.
        Map<String, Object> existingFields = new HashMap<>();
        existingFields.put("existingField1", "value1");
        existingFields.put("existingField2", "value2");
        return existingFields;
    }

    public static void main(String[] args) {
        Mappings inputMappings = new Mappings();
        inputMappings.addField("newField1", "value1");
        inputMappings.addField("existingField1", "value2");

        Mappings result = diffStructure("exampleTable", inputMappings);
        System.out.println("Diff Mappings: " + result.getFields());
    }
}
import java.util.HashMap;
import java.util.Map;

public class Mappings {
    private Map<String, String> fields;

    public Mappings() {
        this.fields = new HashMap<>();
    }

    public void addField(String fieldName, String fieldType) {
        fields.put(fieldName, fieldType);
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public static Mappings diffStructure(String tableName, Mappings mappings) {
        // Simulated existing fields in the current index for the given tableName
        Map<String, String> existingFields = getExistingFieldsForTable(tableName);
        
        Mappings diffMappings = new Mappings();
        
        for (String field : mappings.getFields().keySet()) {
            if (!existingFields.containsKey(field)) {
                diffMappings.addField(field, mappings.getFields().get(field));
            }
        }
        
        return diffMappings;
    }

    private static Map<String, String> getExistingFieldsForTable(String tableName) {
        // This method should return the existing fields for the given tableName.
        // For demonstration purposes, we will return a static map.
        Map<String, String> existingFields = new HashMap<>();
        existingFields.put("id", "integer");
        existingFields.put("name", "string");
        return existingFields;
    }

    public static void main(String[] args) {
        Mappings newMappings = new Mappings();
        newMappings.addField("age", "integer");
        newMappings.addField("address", "string");

        Mappings result = diffStructure("users", newMappings);
        System.out.println("New fields that do not exist in the current mappings:");
        for (String field : result.getFields().keySet()) {
            System.out.println(field + ": " + result.getFields().get(field));
        }
    }
}
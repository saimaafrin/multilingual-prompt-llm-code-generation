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
        Mappings result = new Mappings();
        Map<String, Object> currentFields = getCurrentFieldsForTable(tableName);
        Map<String, Object> inputFields = mappings.getFields();

        for (Map.Entry<String, Object> entry : inputFields.entrySet()) {
            String fieldName = entry.getKey();
            if (!currentFields.containsKey(fieldName)) {
                result.getFields().put(fieldName, entry.getValue());
            }
        }

        return result;
    }

    private Map<String, Object> getCurrentFieldsForTable(String tableName) {
        // This method should return the current fields for the given table.
        // For the sake of this example, we'll return a dummy map.
        Map<String, Object> currentFields = new HashMap<>();
        currentFields.put("field1", "value1");
        currentFields.put("field2", "value2");
        return currentFields;
    }

    public static void main(String[] args) {
        MappingDiff diff = new MappingDiff();
        Mappings inputMappings = new Mappings();
        inputMappings.getFields().put("field1", "value1");
        inputMappings.getFields().put("field3", "value3");

        Mappings result = diff.diffStructure("exampleTable", inputMappings);
        System.out.println(result.getFields()); // Output: {field3=value3}
    }
}
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

    /**
     * Returns mappings with fields that do not exist in the input mappings. The input mappings should be history mapping from current index. Do not return _source config to avoid current index update conflict.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Assuming we have a method to get the current mappings for the table
        Mappings currentMappings = getCurrentMappings(tableName);

        Mappings diffMappings = new Mappings();
        Map<String, Object> currentFields = currentMappings.getFields();
        Map<String, Object> inputFields = mappings.getFields();

        for (Map.Entry<String, Object> entry : currentFields.entrySet()) {
            String fieldName = entry.getKey();
            if (!inputFields.containsKey(fieldName) && !fieldName.equals("_source")) {
                diffMappings.getFields().put(fieldName, entry.getValue());
            }
        }

        return diffMappings;
    }

    // Dummy method to simulate getting current mappings for a table
    private Mappings getCurrentMappings(String tableName) {
        Mappings currentMappings = new Mappings();
        Map<String, Object> fields = new HashMap<>();
        fields.put("field1", "type1");
        fields.put("field2", "type2");
        fields.put("_source", "config");
        currentMappings.setFields(fields);
        return currentMappings;
    }

    public static void main(String[] args) {
        MappingDiff mappingDiff = new MappingDiff();
        Mappings inputMappings = new Mappings();
        Map<String, Object> inputFields = new HashMap<>();
        inputFields.put("field1", "type1");
        inputMappings.setFields(inputFields);

        Mappings diff = mappingDiff.diffStructure("exampleTable", inputMappings);
        System.out.println(diff.getFields()); // Output: {field2=type2}
    }
}
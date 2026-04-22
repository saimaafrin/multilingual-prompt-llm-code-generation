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
     *
     * @param tableName The name of the table.
     * @param mappings The current mappings to compare against.
     * @return A new Mappings object containing fields that are not in the input mappings.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        Mappings result = new Mappings();
        Map<String, Object> currentFields = getCurrentMappings(tableName).getFields();
        Map<String, Object> historyFields = mappings.getFields();

        for (Map.Entry<String, Object> entry : currentFields.entrySet()) {
            if (!historyFields.containsKey(entry.getKey())) {
                result.getFields().put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }

    // Dummy method to simulate fetching current mappings for a table
    private Mappings getCurrentMappings(String tableName) {
        Mappings currentMappings = new Mappings();
        Map<String, Object> fields = new HashMap<>();
        fields.put("field1", "type1");
        fields.put("field2", "type2");
        fields.put("field3", "type3");
        currentMappings.setFields(fields);
        return currentMappings;
    }
}
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

    /**
     * Returns mappings with fields that do not exist in the input mappings. The input mappings should be history mapping from current index. Do not return _source config to avoid current index update conflict.
     *
     * @param tableName The name of the table.
     * @param mappings The current mappings to compare against.
     * @return A new Mappings object containing only the fields that are not present in the input mappings.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        Mappings currentMappings = getCurrentMappings(tableName);
        Mappings diffMappings = new Mappings();

        for (Map.Entry<String, Object> entry : currentMappings.getProperties().entrySet()) {
            String fieldName = entry.getKey();
            if (!mappings.getProperties().containsKey(fieldName)) {
                diffMappings.getProperties().put(fieldName, entry.getValue());
            }
        }

        return diffMappings;
    }

    // Dummy method to simulate fetching current mappings for a table
    private Mappings getCurrentMappings(String tableName) {
        Mappings currentMappings = new Mappings();
        // Simulate some mappings
        currentMappings.getProperties().put("field1", "type1");
        currentMappings.getProperties().put("field2", "type2");
        currentMappings.getProperties().put("field3", "type3");
        return currentMappings;
    }

    public static void main(String[] args) {
        MappingDiff diff = new MappingDiff();
        Mappings historyMappings = new Mappings();
        historyMappings.getProperties().put("field1", "type1");

        Mappings diffMappings = diff.diffStructure("exampleTable", historyMappings);
        System.out.println("Diff Mappings: " + diffMappings.getProperties());
    }
}
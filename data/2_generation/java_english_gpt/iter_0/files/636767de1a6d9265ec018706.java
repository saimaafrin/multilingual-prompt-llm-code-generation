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
        // Simulated existing mappings for the current index
        Mappings existingMappings = new Mappings();
        existingMappings.addField("id", "integer");
        existingMappings.addField("name", "string");
        existingMappings.addField("created_at", "date");

        Mappings diffMappings = new Mappings();

        for (String field : mappings.getFields().keySet()) {
            if (!existingMappings.getFields().containsKey(field)) {
                diffMappings.addField(field, mappings.getFields().get(field));
            }
        }

        return diffMappings;
    }

    public static void main(String[] args) {
        Mappings newMappings = new Mappings();
        newMappings.addField("email", "string");
        newMappings.addField("address", "string");

        Mappings result = diffStructure("users", newMappings);
        System.out.println("New fields that do not exist in the current mappings:");
        for (Map.Entry<String, String> entry : result.getFields().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
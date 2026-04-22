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
        // Simulating a history mapping for the current index
        Mappings currentIndexMappings = new Mappings();
        currentIndexMappings.addField("id", "integer");
        currentIndexMappings.addField("name", "string");
        currentIndexMappings.addField("created_at", "date");

        Mappings diffMappings = new Mappings();

        for (String field : mappings.getFields().keySet()) {
            if (!currentIndexMappings.getFields().containsKey(field)) {
                diffMappings.addField(field, mappings.getFields().get(field));
            }
        }

        return diffMappings;
    }

    public static void main(String[] args) {
        Mappings inputMappings = new Mappings();
        inputMappings.addField("description", "text");
        inputMappings.addField("updated_at", "date");

        Mappings result = diffStructure("example_table", inputMappings);
        System.out.println("Fields not in current index mappings: " + result.getFields());
    }
}
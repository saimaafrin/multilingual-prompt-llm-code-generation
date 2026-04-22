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
}

public class MappingDiff {

    /**
     * 返回输入映射中不存在的字段的映射。输入映射应为当前索引的历史映射。为了避免当前索引更新冲突，请不要返回 _source 配置。
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Simulating the current index structure for demonstration purposes
        Mappings currentMappings = new Mappings();
        currentMappings.addField("id", "integer");
        currentMappings.addField("name", "string");
        currentMappings.addField("email", "string");

        Mappings diffMappings = new Mappings();

        for (String field : mappings.getFields().keySet()) {
            if (!currentMappings.getFields().containsKey(field)) {
                diffMappings.addField(field, mappings.getFields().get(field));
            }
        }

        return diffMappings;
    }

    public static void main(String[] args) {
        MappingDiff mappingDiff = new MappingDiff();
        Mappings historicalMappings = new Mappings();
        historicalMappings.addField("id", "integer");
        historicalMappings.addField("address", "string");
        historicalMappings.addField("phone", "string");

        Mappings result = mappingDiff.diffStructure("exampleTable", historicalMappings);
        System.out.println("Missing fields in current mappings:");
        for (String field : result.getFields().keySet()) {
            System.out.println(field + ": " + result.getFields().get(field));
        }
    }
}
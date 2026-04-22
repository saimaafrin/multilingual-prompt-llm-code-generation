import java.util.HashMap;
import java.util.Map;

public class Mappings {
    private Map<String, Object> fields;

    public Mappings() {
        this.fields = new HashMap<>();
    }

    public void addField(String fieldName, Object fieldConfig) {
        fields.put(fieldName, fieldConfig);
    }

    public Map<String, Object> getFields() {
        return fields;
    }
}

public class MappingDiff {

    /**
     * 返回输入映射中不存在的字段的映射。输入映射应为当前索引的历史映射。为了避免当前索引更新冲突，请不要返回 _source 配置。
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Assuming we have a method to get the current mappings for the table
        Mappings currentMappings = getCurrentMappings(tableName);

        Mappings diffMappings = new Mappings();

        for (Map.Entry<String, Object> entry : mappings.getFields().entrySet()) {
            String fieldName = entry.getKey();
            Object fieldConfig = entry.getValue();

            // Skip _source configuration
            if ("_source".equals(fieldName)) {
                continue;
            }

            // Check if the field exists in the current mappings
            if (!currentMappings.getFields().containsKey(fieldName)) {
                diffMappings.addField(fieldName, fieldConfig);
            }
        }

        return diffMappings;
    }

    // Dummy method to simulate getting current mappings for a table
    private Mappings getCurrentMappings(String tableName) {
        // In a real implementation, this would fetch the current mappings from the index
        Mappings currentMappings = new Mappings();
        currentMappings.addField("existingField1", "config1");
        currentMappings.addField("existingField2", "config2");
        return currentMappings;
    }
}
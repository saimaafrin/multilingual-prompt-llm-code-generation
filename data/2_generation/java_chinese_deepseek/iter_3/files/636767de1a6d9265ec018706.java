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
     * 返回输入映射中不存在的字段的映射。输入映射应为当前索引的历史映射。为了避免当前索引更新冲突，请不要返回 _source 配置。
     *
     * @param tableName 表名
     * @param mappings  当前索引的历史映射
     * @return 不存在的字段的映射
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // 假设我们有一个方法来获取当前表的映射
        Mappings currentMappings = getCurrentMappings(tableName);

        Mappings diffMappings = new Mappings();
        Map<String, Object> currentFields = currentMappings.getFields();
        Map<String, Object> inputFields = mappings.getFields();

        for (Map.Entry<String, Object> entry : inputFields.entrySet()) {
            String fieldName = entry.getKey();
            if (!currentFields.containsKey(fieldName)) {
                diffMappings.getFields().put(fieldName, entry.getValue());
            }
        }

        return diffMappings;
    }

    // 假设的方法，用于获取当前表的映射
    private Mappings getCurrentMappings(String tableName) {
        // 这里应该是从数据库或其他存储中获取当前表的映射
        // 为了示例，我们返回一个空的Mappings对象
        return new Mappings();
    }
}
import java.util.Objects;

public class ColumnNameOverride {
    
    /**
     * 保持与 {@link ColumnName#overrideName(String,String)} 相同的名称替换
     * @param oldName 要被替换的名称。
     * @param newName 在存储层使用的新名称。
     */
    public void overrideName(String oldName, String newName) {
        // Validate input parameters
        if (Objects.isNull(oldName) || Objects.isNull(newName)) {
            throw new IllegalArgumentException("Column names cannot be null");
        }
        
        if (oldName.trim().isEmpty() || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Column names cannot be empty");
        }
        
        // Store the mapping of old name to new name
        // This implementation assumes there is a map field in the class to store the mappings
        columnNameMappings.put(oldName.trim(), newName.trim());
    }
    
    // Map to store column name mappings
    private Map<String, String> columnNameMappings = new HashMap<>();
}
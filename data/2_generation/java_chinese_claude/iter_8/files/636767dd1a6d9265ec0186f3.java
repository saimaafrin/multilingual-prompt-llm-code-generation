import java.util.Objects;

public class ColumnNameOverride {

    /**
     * 保持与 {@link ColumnName#overrideName(String,String)} 相同的名称替换
     * @param oldName 要被替换的名称。
     * @param newName 在存储层使用的新名称。
     */
    public void overrideName(String oldName, String newName) {
        // Validate input parameters
        Objects.requireNonNull(oldName, "oldName cannot be null");
        Objects.requireNonNull(newName, "newName cannot be null");
        
        if (oldName.isEmpty()) {
            throw new IllegalArgumentException("oldName cannot be empty");
        }
        
        if (newName.isEmpty()) {
            throw new IllegalArgumentException("newName cannot be empty"); 
        }

        // Here we would typically update the name mapping in some storage
        // For example, if using a Map to store the override mappings:
        // nameOverrides.put(oldName, newName);
    }
}
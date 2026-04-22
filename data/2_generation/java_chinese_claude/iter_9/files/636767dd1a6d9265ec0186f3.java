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

        // Trim whitespace from names
        String trimmedOldName = oldName.trim();
        String trimmedNewName = newName.trim();

        // Store the name mapping (implementation depends on storage mechanism)
        storeNameMapping(trimmedOldName, trimmedNewName);
    }

    // Helper method to store the name mapping
    private void storeNameMapping(String oldName, String newName) {
        // Implementation would depend on storage requirements
        // Could store in a Map, database, etc.
    }
}
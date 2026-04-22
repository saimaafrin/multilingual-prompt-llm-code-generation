import java.util.Objects;

public class ColumnName {

    /**
     * Keep the same name replacement as {@link ColumnName#overrideName(String,String)}
     * @param oldName to be replaced.
     * @param newName to use in the storage level.
     */
    public void overrideName(String oldName, String newName) {
        if (Objects.isNull(oldName) || Objects.isNull(newName)) {
            throw new IllegalArgumentException("Column names cannot be null");
        }
        
        if (oldName.isEmpty() || newName.isEmpty()) {
            throw new IllegalArgumentException("Column names cannot be empty");
        }
        
        // Store the name mapping
        columnNameMap.put(oldName.toLowerCase(), newName.toLowerCase());
    }
    
    // Map to store column name mappings
    private Map<String, String> columnNameMap = new HashMap<>();
}
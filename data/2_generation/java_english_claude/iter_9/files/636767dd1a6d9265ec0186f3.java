import java.util.HashMap;
import java.util.Map;

public class ColumnName {
    private Map<String, String> nameOverrides;

    public ColumnName() {
        nameOverrides = new HashMap<>();
    }

    /**
     * Keep the same name replacement as {@link ColumnName#overrideName(String,String)}
     * @param oldName to be replaced.
     * @param newName to use in the storage level.
     */
    public void overrideName(String oldName, String newName) {
        if (oldName == null || newName == null) {
            throw new IllegalArgumentException("Column names cannot be null");
        }
        
        nameOverrides.put(oldName.trim(), newName.trim());
    }
}
import java.util.HashMap;
import java.util.Map;

public class ColumnName {
    private Map<String, String> nameMap;

    public ColumnName() {
        nameMap = new HashMap<>();
    }

    /**
     * Keep the same name replacement as {@link ColumnName#overrideName(String, String)}
     * @param oldName to be replaced.
     * @param newName to use in the storage level.
     */
    public void overrideName(String oldName, String newName) {
        if (oldName == null || newName == null) {
            throw new IllegalArgumentException("Old name and new name cannot be null.");
        }
        nameMap.put(oldName, newName);
    }

    public String getNewName(String oldName) {
        return nameMap.get(oldName);
    }
}
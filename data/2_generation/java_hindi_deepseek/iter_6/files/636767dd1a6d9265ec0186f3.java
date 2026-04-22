import java.util.HashMap;
import java.util.Map;

public class ColumnName {
    private Map<String, String> nameMap;

    public ColumnName() {
        nameMap = new HashMap<>();
    }

    /**
     * {@link ColumnName#overrideName(String,String)} के समान नाम प्रतिस्थापन बनाए रखें।
     * @param oldName जिसे प्रतिस्थापित किया जाना है।
     * @param newName जिसे संग्रहण स्तर में उपयोग करना है।
     */
    public void overrideName(String oldName, String newName) {
        if (oldName == null || newName == null) {
            throw new IllegalArgumentException("Old name and new name cannot be null.");
        }
        nameMap.put(oldName, newName);
    }

    public String getNewName(String oldName) {
        return nameMap.getOrDefault(oldName, oldName);
    }
}
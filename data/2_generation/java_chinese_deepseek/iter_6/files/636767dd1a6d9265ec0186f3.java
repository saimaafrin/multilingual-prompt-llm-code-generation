import java.util.HashMap;
import java.util.Map;

public class ColumnName {
    private Map<String, String> nameMap;

    public ColumnName() {
        this.nameMap = new HashMap<>();
    }

    /**
     * 保持与 {@link ColumnName#overrideName(String,String)} 相同的名称替换
     * @param oldName 要被替换的名称。
     * @param newName 在存储层使用的新名称。
     */
    public void overrideName(String oldName, String newName) {
        if (oldName == null || newName == null) {
            throw new IllegalArgumentException("Old name and new name cannot be null.");
        }
        nameMap.put(oldName, newName);
    }

    public String getOverrideName(String oldName) {
        return nameMap.getOrDefault(oldName, oldName);
    }

    public static void main(String[] args) {
        ColumnName columnName = new ColumnName();
        columnName.overrideName("oldColumn", "newColumn");
        System.out.println(columnName.getOverrideName("oldColumn")); // Output: newColumn
    }
}
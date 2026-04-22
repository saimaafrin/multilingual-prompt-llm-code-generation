import java.util.HashMap;
import java.util.Map;

public class ColumnName {
    private Map<String, String> columnNames;

    public ColumnName() {
        this.columnNames = new HashMap<>();
    }

    /**
     * Mantieni lo stesso nome da sostituire come {@link ColumnName#overrideName(String,String)}
     * @param oldName da sostituire.
     * @param newName da utilizzare a livello di archiviazione.
     */
    public void overrideName(String oldName, String newName) {
        if (columnNames.containsKey(oldName)) {
            columnNames.put(newName, columnNames.get(oldName));
            columnNames.remove(oldName);
        } else {
            columnNames.put(newName, oldName);
        }
    }

    public String getColumnName(String key) {
        return columnNames.get(key);
    }

    public static void main(String[] args) {
        ColumnName columnName = new ColumnName();
        columnName.overrideName("oldColumn", "newColumn");
        System.out.println(columnName.getColumnName("newColumn")); // Output: oldColumn
    }
}
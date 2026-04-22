import java.util.HashMap;
import java.util.Map;

public class ColumnName {
    private Map<String, String> columnNames = new HashMap<>();

    /**
     * Mantieni lo stesso nome da sostituire come {@link ColumnName#overrideName(String,String)}
     * @param oldName da sostituire.
     * @param newName da utilizzare a livello di archiviazione.
     */
    public void overrideName(String oldName, String newName) {
        if (oldName == null || newName == null) {
            throw new IllegalArgumentException("I nomi non possono essere nulli.");
        }
        if (columnNames.containsKey(oldName)) {
            String existingNewName = columnNames.get(oldName);
            columnNames.remove(oldName);
            columnNames.put(newName, existingNewName);
        } else {
            columnNames.put(newName, oldName);
        }
    }

    public String getOriginalName(String newName) {
        return columnNames.get(newName);
    }

    public static void main(String[] args) {
        ColumnName columnName = new ColumnName();
        columnName.overrideName("oldColumn", "newColumn");
        System.out.println(columnName.getOriginalName("newColumn")); // Output: oldColumn
    }
}
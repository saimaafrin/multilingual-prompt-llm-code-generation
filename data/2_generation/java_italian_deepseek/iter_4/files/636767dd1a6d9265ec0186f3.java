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
            columnNames.put(oldName, newName);
        }
    }

    public String getNewName(String oldName) {
        return columnNames.get(oldName);
    }

    public static void main(String[] args) {
        ColumnName columnName = new ColumnName();
        columnName.overrideName("oldColumn", "newColumn");
        System.out.println(columnName.getNewName("oldColumn")); // Output: newColumn
    }
}
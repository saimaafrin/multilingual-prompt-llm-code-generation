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
            columnNames.put(oldName, newName);
        } else {
            throw new IllegalArgumentException("Il nome da sostituire non esiste.");
        }
    }

    public void addColumnName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Il nome non può essere nullo.");
        }
        columnNames.put(name, name);
    }

    public String getColumnName(String name) {
        return columnNames.get(name);
    }
}
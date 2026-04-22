import java.util.HashMap;
import java.util.Map;

public class ColumnName {
    private Map<String, String> nameOverrides;

    public ColumnName() {
        nameOverrides = new HashMap<>();
    }

    /**
     * Mantieni lo stesso nome da sostituire come {@link ColumnName#overrideName(String,String)}
     * @param oldName da sostituire.
     * @param newName da utilizzare a livello di archiviazione.
     */
    public void overrideName(String oldName, String newName) {
        if (oldName != null && newName != null) {
            nameOverrides.put(oldName, newName);
        }
    }
}
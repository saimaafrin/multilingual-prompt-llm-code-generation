import java.util.HashMap;
import java.util.Map;

public class ColumnName {
    private Map<String, String> nameMap;

    public ColumnName() {
        this.nameMap = new HashMap<>();
    }

    /**
     * Mantener el mismo reemplazo de nombre que {@link ColumnName#overrideName(String, String)}
     * @param oldName el nombre a ser reemplazado.
     * @param newName el nombre a utilizar en el nivel de almacenamiento.
     */
    public void overrideName(String oldName, String newName) {
        if (oldName == null || newName == null) {
            throw new IllegalArgumentException("Neither oldName nor newName can be null.");
        }
        nameMap.put(oldName, newName);
    }

    public String getOverrideName(String oldName) {
        return nameMap.getOrDefault(oldName, oldName);
    }
}
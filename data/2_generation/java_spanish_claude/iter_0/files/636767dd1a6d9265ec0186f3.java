import java.util.HashMap;
import java.util.Map;

public class ColumnName {
    private Map<String, String> nameOverrides;

    public ColumnName() {
        this.nameOverrides = new HashMap<>();
    }

    /**
     * Mantener el mismo reemplazo de nombre que {@link ColumnName#overrideName(String,String)}
     * @param oldName el nombre a ser reemplazado.
     * @param newName el nombre a utilizar en el nivel de almacenamiento.
     */
    public void overrideName(String oldName, String newName) {
        if (oldName == null || newName == null) {
            throw new IllegalArgumentException("Neither oldName nor newName can be null");
        }
        
        nameOverrides.put(oldName.trim(), newName.trim());
    }
}
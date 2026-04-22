import java.util.HashMap;
import java.util.Map;

public class Mappings {
    private Map<String, Object> properties;

    public Mappings() {
        this.properties = new HashMap<>();
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}

public class MappingDiff {

    /**
     * Devuelve los mapeos con campos que no existen en los mapeos de entrada. Los mapeos de entrada deben ser mapeos de historial del índice actual. No devolver la configuración _source para evitar conflictos de actualización del índice actual.
     *
     * @param tableName El nombre de la tabla o índice.
     * @param mappings Los mapeos de entrada.
     * @return Mapeos con campos que no existen en los mapeos de entrada.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Obtener los mapeos actuales de la tabla (simulado aquí)
        Mappings currentMappings = getCurrentMappings(tableName);

        // Crear un nuevo objeto Mappings para almacenar las diferencias
        Mappings diffMappings = new Mappings();
        Map<String, Object> diffProperties = new HashMap<>();

        // Comparar los mapeos actuales con los mapeos de entrada
        for (Map.Entry<String, Object> entry : currentMappings.getProperties().entrySet()) {
            String key = entry.getKey();
            if (!mappings.getProperties().containsKey(key) && !key.equals("_source")) {
                diffProperties.put(key, entry.getValue());
            }
        }

        diffMappings.setProperties(diffProperties);
        return diffMappings;
    }

    // Método simulado para obtener los mapeos actuales de la tabla
    private Mappings getCurrentMappings(String tableName) {
        Mappings currentMappings = new Mappings();
        Map<String, Object> properties = new HashMap<>();
        properties.put("field1", "type1");
        properties.put("field2", "type2");
        properties.put("_source", "enabled");
        currentMappings.setProperties(properties);
        return currentMappings;
    }
}
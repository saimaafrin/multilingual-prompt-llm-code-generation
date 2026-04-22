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
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Supongamos que tenemos un método para obtener los mapeos actuales de la tabla
        Mappings currentMappings = getCurrentMappings(tableName);

        Mappings diffMappings = new Mappings();
        Map<String, Object> currentProperties = currentMappings.getProperties();
        Map<String, Object> inputProperties = mappings.getProperties();

        for (Map.Entry<String, Object> entry : inputProperties.entrySet()) {
            String key = entry.getKey();
            if (!currentProperties.containsKey(key) && !key.equals("_source")) {
                diffMappings.getProperties().put(key, entry.getValue());
            }
        }

        return diffMappings;
    }

    // Método simulado para obtener los mapeos actuales de la tabla
    private Mappings getCurrentMappings(String tableName) {
        // Aquí se simula la obtención de los mapeos actuales
        Mappings currentMappings = new Mappings();
        Map<String, Object> properties = new HashMap<>();
        properties.put("field1", "type1");
        properties.put("field2", "type2");
        currentMappings.setProperties(properties);
        return currentMappings;
    }
}
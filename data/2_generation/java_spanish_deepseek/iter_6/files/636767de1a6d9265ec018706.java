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
        Mappings result = new Mappings();
        Map<String, Object> currentMappings = getCurrentMappings(tableName);
        Map<String, Object> inputMappings = mappings.getProperties();

        for (Map.Entry<String, Object> entry : currentMappings.entrySet()) {
            String key = entry.getKey();
            if (!inputMappings.containsKey(key) && !key.equals("_source")) {
                result.getProperties().put(key, entry.getValue());
            }
        }

        return result;
    }

    private Map<String, Object> getCurrentMappings(String tableName) {
        // Simulación de la obtención de los mapeos actuales de la tabla
        Map<String, Object> currentMappings = new HashMap<>();
        currentMappings.put("field1", "type1");
        currentMappings.put("field2", "type2");
        currentMappings.put("_source", "sourceConfig");
        return currentMappings;
    }

    public static void main(String[] args) {
        MappingDiff diff = new MappingDiff();
        Mappings inputMappings = new Mappings();
        inputMappings.getProperties().put("field1", "type1");

        Mappings result = diff.diffStructure("exampleTable", inputMappings);
        System.out.println(result.getProperties()); // Output: {field2=type2}
    }
}
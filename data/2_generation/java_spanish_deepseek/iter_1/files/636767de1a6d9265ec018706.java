import java.util.HashMap;
import java.util.Map;

public class Mappings {
    private Map<String, Object> fields;

    public Mappings() {
        this.fields = new HashMap<>();
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }
}

public class MappingDiff {

    /**
     * Devuelve los mapeos con campos que no existen en los mapeos de entrada. Los mapeos de entrada deben ser mapeos de historial del índice actual. No devolver la configuración _source para evitar conflictos de actualización del índice actual.
     *
     * @param tableName El nombre de la tabla.
     * @param mappings Los mapeos de entrada.
     * @return Mapeos con campos que no existen en los mapeos de entrada.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        Mappings result = new Mappings();
        Map<String, Object> currentFields = getCurrentMappings(tableName).getFields();
        Map<String, Object> inputFields = mappings.getFields();

        for (Map.Entry<String, Object> entry : currentFields.entrySet()) {
            String key = entry.getKey();
            if (!inputFields.containsKey(key) && !key.equals("_source")) {
                result.getFields().put(key, entry.getValue());
            }
        }

        return result;
    }

    private Mappings getCurrentMappings(String tableName) {
        // Simulación de obtención de mapeos actuales de la tabla
        Mappings currentMappings = new Mappings();
        Map<String, Object> fields = new HashMap<>();
        fields.put("field1", "type1");
        fields.put("field2", "type2");
        fields.put("_source", "sourceConfig");
        currentMappings.setFields(fields);
        return currentMappings;
    }
}
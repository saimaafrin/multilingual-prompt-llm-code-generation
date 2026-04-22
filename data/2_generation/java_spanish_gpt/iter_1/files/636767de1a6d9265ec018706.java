import java.util.HashMap;
import java.util.Map;

public class Mappings {
    private Map<String, String> fields;

    public Mappings() {
        this.fields = new HashMap<>();
    }

    public void addField(String fieldName, String fieldType) {
        fields.put(fieldName, fieldType);
    }

    public Map<String, String> getFields() {
        return fields;
    }
}

public class MappingDiff {

    /**
     * Devuelve los mapeos con campos que no existen en los mapeos de entrada. 
     * Los mapeos de entrada deben ser mapeos de historial del índice actual. 
     * No devolver la configuración _source para evitar conflictos de actualización del índice actual.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Simulando los mapeos actuales del índice
        Mappings currentMappings = getCurrentMappings(tableName);
        
        Mappings diffMappings = new Mappings();
        
        for (Map.Entry<String, String> entry : currentMappings.getFields().entrySet()) {
            String fieldName = entry.getKey();
            if (!mappings.getFields().containsKey(fieldName)) {
                diffMappings.addField(fieldName, entry.getValue());
            }
        }
        
        return diffMappings;
    }

    private Mappings getCurrentMappings(String tableName) {
        // Simulación de la obtención de mapeos actuales
        Mappings currentMappings = new Mappings();
        currentMappings.addField("id", "integer");
        currentMappings.addField("name", "string");
        currentMappings.addField("email", "string");
        // Suponiendo que "email" es un campo que no debería estar en los mapeos de entrada
        return currentMappings;
    }
}
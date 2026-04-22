import java.util.HashMap;
import java.util.Map;

public class MappingDiff {

    public static class Mappings {
        private Map<String, Object> fields;

        public Mappings() {
            this.fields = new HashMap<>();
        }

        public void addField(String fieldName, Object fieldValue) {
            fields.put(fieldName, fieldValue);
        }

        public Map<String, Object> getFields() {
            return fields;
        }
    }

    /**
     * Devuelve los mapeos con campos que no existen en los mapeos de entrada. 
     * Los mapeos de entrada deben ser mapeos de historial del índice actual. 
     * No devolver la configuración _source para evitar conflictos de actualización del índice actual.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Simulando los mapeos actuales del índice
        Mappings currentMappings = getCurrentMappings(tableName);
        
        Mappings diffMappings = new Mappings();
        
        for (String field : currentMappings.getFields().keySet()) {
            if (!mappings.getFields().containsKey(field)) {
                diffMappings.addField(field, currentMappings.getFields().get(field));
            }
        }
        
        return diffMappings;
    }

    private Mappings getCurrentMappings(String tableName) {
        // Simulación de la obtención de mapeos actuales
        Mappings currentMappings = new Mappings();
        currentMappings.addField("id", "integer");
        currentMappings.addField("name", "string");
        currentMappings.addField("created_at", "date");
        // Suponiendo que "source" no se debe incluir
        return currentMappings;
    }

    public static void main(String[] args) {
        MappingDiff mappingDiff = new MappingDiff();
        Mappings inputMappings = new Mappings();
        inputMappings.addField("id", "integer"); // Campo existente
        // No se añade "name" ni "created_at" para simular la diferencia

        Mappings result = mappingDiff.diffStructure("example_table", inputMappings);
        System.out.println("Diff Mappings: " + result.getFields());
    }
}
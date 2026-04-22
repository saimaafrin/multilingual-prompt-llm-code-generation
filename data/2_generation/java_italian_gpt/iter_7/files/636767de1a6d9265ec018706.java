import java.util.HashMap;
import java.util.Map;

public class MappingDiff {

    public static class Mappings {
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

    /**
     * Restituisce le mappature con i campi che non esistono nelle mappature di input. 
     * Le mappature di input devono essere le mappature storiche dall'indice corrente. 
     * Non restituire la configurazione _source per evitare conflitti di aggiornamento dell'indice corrente.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Simulazione delle mappature storiche
        Mappings historicalMappings = getHistoricalMappings(tableName);
        
        Mappings diffMappings = new Mappings();
        
        for (Map.Entry<String, String> entry : historicalMappings.getFields().entrySet()) {
            String fieldName = entry.getKey();
            if (!mappings.getFields().containsKey(fieldName)) {
                diffMappings.addField(fieldName, entry.getValue());
            }
        }
        
        return diffMappings;
    }

    private Mappings getHistoricalMappings(String tableName) {
        // Simulazione di recupero delle mappature storiche
        Mappings historicalMappings = new Mappings();
        // Aggiunta di campi storici per esempio
        historicalMappings.addField("id", "integer");
        historicalMappings.addField("name", "string");
        historicalMappings.addField("email", "string");
        historicalMappings.addField("created_at", "date");
        return historicalMappings;
    }

    public static void main(String[] args) {
        MappingDiff mappingDiff = new MappingDiff();
        Mappings currentMappings = new Mappings();
        currentMappings.addField("id", "integer");
        currentMappings.addField("name", "string");

        Mappings diff = mappingDiff.diffStructure("users", currentMappings);
        System.out.println("Differenze nelle mappature:");
        for (Map.Entry<String, String> entry : diff.getFields().entrySet()) {
            System.out.println("Campo: " + entry.getKey() + ", Tipo: " + entry.getValue());
        }
    }
}
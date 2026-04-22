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
     * Restituisce le mappature con i campi che non esistono nelle mappature di input. 
     * Le mappature di input devono essere le mappature storiche dall'indice corrente. 
     * Non restituire la configurazione _source per evitare conflitti di aggiornamento dell'indice corrente.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Simulazione di mappature storiche per l'esempio
        Mappings historicalMappings = new Mappings();
        historicalMappings.addField("id", "integer");
        historicalMappings.addField("name", "string");
        historicalMappings.addField("email", "string");
        
        // Creazione di un nuovo oggetto Mappings per le differenze
        Mappings diffMappings = new Mappings();
        
        // Controllo dei campi nelle mappature di input
        for (String field : historicalMappings.getFields().keySet()) {
            if (!mappings.getFields().containsKey(field)) {
                // Aggiungi il campo mancante alle differenze
                diffMappings.addField(field, historicalMappings.getFields().get(field));
            }
        }
        
        return diffMappings;
    }

    public static void main(String[] args) {
        MappingDiff mappingDiff = new MappingDiff();
        Mappings currentMappings = new Mappings();
        currentMappings.addField("id", "integer");
        
        Mappings result = mappingDiff.diffStructure("exampleTable", currentMappings);
        System.out.println("Missing fields:");
        for (String field : result.getFields().keySet()) {
            System.out.println(field + ": " + result.getFields().get(field));
        }
    }
}
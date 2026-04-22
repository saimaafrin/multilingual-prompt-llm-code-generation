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
        // Simulación de mapeos históricos para la tabla dada
        Mappings historicalMappings = getHistoricalMappings(tableName);

        Mappings result = new Mappings();
        Map<String, Object> resultProperties = new HashMap<>();

        // Obtener las propiedades de los mapeos de entrada
        Map<String, Object> inputProperties = mappings.getProperties();

        // Obtener las propiedades de los mapeos históricos
        Map<String, Object> historicalProperties = historicalMappings.getProperties();

        // Comparar las propiedades de entrada con las históricas
        for (Map.Entry<String, Object> entry : inputProperties.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            // Si la clave no existe en los mapeos históricos, agregarla al resultado
            if (!historicalProperties.containsKey(key)) {
                resultProperties.put(key, value);
            }
        }

        // No incluir la configuración _source en el resultado
        resultProperties.remove("_source");

        result.setProperties(resultProperties);
        return result;
    }

    private Mappings getHistoricalMappings(String tableName) {
        // Simulación de mapeos históricos para la tabla dada
        Mappings historicalMappings = new Mappings();
        Map<String, Object> historicalProperties = new HashMap<>();
        historicalProperties.put("field1", "type1");
        historicalProperties.put("field2", "type2");
        historicalMappings.setProperties(historicalProperties);
        return historicalMappings;
    }

    public static void main(String[] args) {
        MappingDiff mappingDiff = new MappingDiff();

        Mappings inputMappings = new Mappings();
        Map<String, Object> inputProperties = new HashMap<>();
        inputProperties.put("field1", "type1");
        inputProperties.put("field3", "type3");
        inputProperties.put("_source", "enabled");
        inputMappings.setProperties(inputProperties);

        Mappings result = mappingDiff.diffStructure("exampleTable", inputMappings);

        System.out.println("Mapeos con campos que no existen en los mapeos históricos:");
        for (Map.Entry<String, Object> entry : result.getProperties().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
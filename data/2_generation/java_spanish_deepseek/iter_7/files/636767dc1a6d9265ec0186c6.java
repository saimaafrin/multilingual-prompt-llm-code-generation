import java.util.Set;

public class Fields {
    private Set<String> storedFields;

    public Fields(Set<String> storedFields) {
        this.storedFields = storedFields;
    }

    public Set<String> getStoredFields() {
        return storedFields;
    }
}

public class Example {
    /**
     * Devuelve verdadero cuando los campos de entrada ya han sido almacenados en las propiedades.
     */
    private boolean containsAllFields(Fields fields) {
        // Suponiendo que tenemos un conjunto de campos almacenados en la clase
        Set<String> storedFields = getStoredFields(); // Método hipotético para obtener los campos almacenados
        return storedFields.containsAll(fields.getStoredFields());
    }

    // Método hipotético para obtener los campos almacenados
    private Set<String> getStoredFields() {
        // Implementación de ejemplo
        return Set.of("field1", "field2", "field3");
    }
}
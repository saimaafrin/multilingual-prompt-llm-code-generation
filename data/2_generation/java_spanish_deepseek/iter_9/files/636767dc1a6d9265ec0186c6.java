import java.util.Set;
import java.util.HashSet;

public class FieldChecker {
    private Set<Fields> storedFields = new HashSet<>();

    /**
     * Devuelve verdadero cuando los campos de entrada ya han sido almacenados en las propiedades.
     */
    private boolean containsAllFields(Fields fields) {
        return storedFields.contains(fields);
    }

    // Assuming Fields is a class or enum, you would need to define it or import it.
    // For example:
    // public enum Fields { FIELD1, FIELD2, FIELD3 }
}
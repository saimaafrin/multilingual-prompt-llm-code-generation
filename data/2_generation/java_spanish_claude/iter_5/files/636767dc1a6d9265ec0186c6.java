import java.util.Objects;

public class FieldValidator {

    private Fields storedFields;

    /**
     * Devuelve verdadero cuando los campos de entrada ya han sido almacenados en las propiedades.
     */
    private boolean containsAllFields(Fields fields) {
        if (fields == null) {
            return false;
        }

        if (storedFields == null) {
            return false;
        }

        return Objects.equals(storedFields, fields);
    }
}
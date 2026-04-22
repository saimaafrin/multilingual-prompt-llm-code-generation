import java.util.Objects;

public class FieldValidator {
    
    private Set<Fields> storedFields;

    public FieldValidator() {
        this.storedFields = new HashSet<>();
    }

    /**
     * Restituisce true quando i campi di input sono già stati memorizzati nelle proprietà.
     */
    private boolean containsAllFields(Fields fields) {
        if (fields == null) {
            return false;
        }
        return storedFields.contains(fields);
    }
}
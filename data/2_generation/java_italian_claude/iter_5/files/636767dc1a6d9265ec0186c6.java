import java.util.Objects;

public class FieldValidator {
    
    private Fields storedFields;
    
    /**
     * Restituisce true quando i campi di input sono già stati memorizzati nelle proprietà.
     */
    private boolean containsAllFields(Fields fields) {
        if (fields == null || storedFields == null) {
            return false;
        }
        
        return Objects.equals(storedFields, fields);
    }
}
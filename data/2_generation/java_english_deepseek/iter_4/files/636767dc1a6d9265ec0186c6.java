import java.util.Properties;
import java.util.Set;

public class FieldChecker {
    private Properties storedProperties;

    public FieldChecker(Properties storedProperties) {
        this.storedProperties = storedProperties;
    }

    /**
     * Returns true when the input fields have already been stored in the properties.
     */
    private boolean containsAllFields(Fields fields) {
        Set<String> fieldNames = fields.getFieldNames();
        for (String fieldName : fieldNames) {
            if (!storedProperties.containsKey(fieldName)) {
                return false;
            }
        }
        return true;
    }
}

class Fields {
    private Set<String> fieldNames;

    public Fields(Set<String> fieldNames) {
        this.fieldNames = fieldNames;
    }

    public Set<String> getFieldNames() {
        return fieldNames;
    }
}
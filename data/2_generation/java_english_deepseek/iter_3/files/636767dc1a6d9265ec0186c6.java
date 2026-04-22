import java.util.Properties;

public class FieldChecker {
    private Properties storedProperties;

    public FieldChecker(Properties storedProperties) {
        this.storedProperties = storedProperties;
    }

    /**
     * Returns true when the input fields have already been stored in the properties.
     */
    private boolean containsAllFields(Fields fields) {
        for (String fieldName : fields.getFieldNames()) {
            if (!storedProperties.containsKey(fieldName)) {
                return false;
            }
        }
        return true;
    }
}

class Fields {
    private String[] fieldNames;

    public Fields(String[] fieldNames) {
        this.fieldNames = fieldNames;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }
}
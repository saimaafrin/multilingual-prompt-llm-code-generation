import java.util.Properties;

public class FieldValidator {
    private Properties properties;

    public FieldValidator() {
        this.properties = new Properties();
    }

    /**
     * Returns true when the input fields have already been stored in the properties.
     */
    private boolean containsAllFields(Fields fields) {
        if (fields == null) {
            return false;
        }

        for (String fieldName : fields.getFieldNames()) {
            if (!properties.containsKey(fieldName)) {
                return false;
            }
        }
        return true;
    }
}
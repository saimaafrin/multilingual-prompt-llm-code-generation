import java.util.Properties;

public class FieldChecker {
    private Properties properties;

    public FieldChecker(Properties properties) {
        this.properties = properties;
    }

    /** 
     * Returns true when the input fields have already been stored in the properties.
     */
    private boolean containsAllFields(Fields fields) {
        for (String field : fields.getFieldNames()) {
            if (!properties.containsKey(field)) {
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
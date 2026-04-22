import java.util.Properties;

public class PropertyChecker {
    private Properties properties;

    public PropertyChecker() {
        this.properties = new Properties();
    }

    /**
     * Returns true when the input fields have already been stored in the properties.
     * @param fields Array of field names to check
     * @return boolean indicating if all fields exist in properties
     */
    public boolean areFieldsStored(String[] fields) {
        if (fields == null || fields.length == 0) {
            return false;
        }

        for (String field : fields) {
            if (field == null || !properties.containsKey(field)) {
                return false;
            }
        }
        return true;
    }

    // Helper method to add properties for testing
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
}
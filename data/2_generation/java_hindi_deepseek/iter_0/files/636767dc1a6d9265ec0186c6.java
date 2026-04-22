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
     * जब इनपुट फ़ील्ड पहले से ही प्रॉपर्टीज़ में संग्रहीत होते हैं, तो यह सत्य (true) लौटाता है।
     */
    private boolean containsAllFields(Fields fields) {
        Set<String> inputFields = fields.getStoredFields();
        // Assuming 'properties' is a Set<String> containing the stored properties
        return properties.containsAll(inputFields);
    }

    // Assuming 'properties' is a Set<String> containing the stored properties
    private Set<String> properties;

    public Example(Set<String> properties) {
        this.properties = properties;
    }
}
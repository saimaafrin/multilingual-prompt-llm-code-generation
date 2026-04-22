import java.util.Set;

public class FieldChecker {

    /**
     * जब इनपुट फ़ील्ड पहले से ही प्रॉपर्टीज़ में संग्रहीत होते हैं, तो यह सत्य (true) लौटाता है।
     */
    private boolean containsAllFields(Fields fields) {
        // Assuming Fields is a class that contains a Set<String> of stored properties
        Set<String> storedProperties = fields.getStoredProperties();
        Set<String> inputFields = fields.getInputFields();

        // Check if all input fields are present in the stored properties
        return storedProperties.containsAll(inputFields);
    }

    // Assuming the Fields class is defined as follows:
    public static class Fields {
        private Set<String> storedProperties;
        private Set<String> inputFields;

        public Fields(Set<String> storedProperties, Set<String> inputFields) {
            this.storedProperties = storedProperties;
            this.inputFields = inputFields;
        }

        public Set<String> getStoredProperties() {
            return storedProperties;
        }

        public Set<String> getInputFields() {
            return inputFields;
        }
    }
}
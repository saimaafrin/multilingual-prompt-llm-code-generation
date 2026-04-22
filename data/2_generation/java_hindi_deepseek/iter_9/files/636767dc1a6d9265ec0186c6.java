import java.util.Set;

public class FieldChecker {

    /**
     * जब इनपुट फ़ील्ड पहले से ही प्रॉपर्टीज़ में संग्रहीत होते हैं, तो यह सत्य (true) लौटाता है।
     */
    private boolean containsAllFields(Fields fields) {
        // Assuming Fields is a class that contains a Set<String> of field names
        Set<String> storedFields = getStoredFields(); // Method to retrieve stored fields
        Set<String> inputFields = fields.getFieldNames(); // Method to get input field names

        // Check if all input fields are present in the stored fields
        return storedFields.containsAll(inputFields);
    }

    // Dummy method to simulate retrieval of stored fields
    private Set<String> getStoredFields() {
        // This would typically be replaced with actual logic to retrieve stored fields
        return Set.of("field1", "field2", "field3");
    }

    // Dummy Fields class for demonstration
    public static class Fields {
        private Set<String> fieldNames;

        public Fields(Set<String> fieldNames) {
            this.fieldNames = fieldNames;
        }

        public Set<String> getFieldNames() {
            return fieldNames;
        }
    }

    public static void main(String[] args) {
        FieldChecker checker = new FieldChecker();
        Fields inputFields = new Fields(Set.of("field1", "field2"));
        System.out.println(checker.containsAllFields(inputFields)); // Should print true if fields are stored
    }
}
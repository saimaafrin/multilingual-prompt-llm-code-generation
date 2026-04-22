import java.util.Set;

public class FieldChecker {

    /**
     * जब इनपुट फ़ील्ड पहले से ही प्रॉपर्टीज़ में संग्रहीत होते हैं, तो यह सत्य (true) लौटाता है।
     * 
     * @param fields इनपुट फ़ील्ड्स
     * @return true यदि सभी फ़ील्ड्स प्रॉपर्टीज़ में मौजूद हैं, अन्यथा false
     */
    private boolean containsAllFields(Fields fields) {
        // Assuming Fields is a class that contains a Set of field names
        Set<String> storedProperties = getStoredProperties(); // Method to get stored properties
        Set<String> inputFields = fields.getFieldNames(); // Method to get input field names

        // Check if all input fields are present in stored properties
        return storedProperties.containsAll(inputFields);
    }

    // Dummy method to simulate stored properties
    private Set<String> getStoredProperties() {
        // Return a set of stored property names
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
        Fields fields = new Fields(Set.of("field1", "field2"));
        System.out.println(checker.containsAllFields(fields)); // Should print true
    }
}
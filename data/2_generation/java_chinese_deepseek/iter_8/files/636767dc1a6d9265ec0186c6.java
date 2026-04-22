import java.util.Set;

public class FieldChecker {

    /**
     * 当输入字段已经存储在属性中时返回真。
     */
    private boolean containsAllFields(Fields fields) {
        // Assuming Fields is a class that contains a Set of field names
        Set<String> storedFields = getStoredFields(); // This method should return the stored fields
        Set<String> inputFields = fields.getFieldNames(); // Assuming Fields has a method to get field names

        return storedFields.containsAll(inputFields);
    }

    // Dummy method to simulate getting stored fields
    private Set<String> getStoredFields() {
        // This should return the actual stored fields
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
        System.out.println(checker.containsAllFields(inputFields)); // Should print true or false based on stored fields
    }
}
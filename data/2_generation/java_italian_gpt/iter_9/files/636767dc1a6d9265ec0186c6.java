public class FieldChecker {

    private Fields storedFields;

    /**
     * Restituisce true quando i campi di input sono già stati memorizzati nelle proprietà.
     */
    private boolean containsAllFields(Fields fields) {
        if (storedFields == null) {
            return false;
        }
        return storedFields.equals(fields);
    }

    // Assuming Fields class has been defined elsewhere
    public void setStoredFields(Fields fields) {
        this.storedFields = fields;
    }
    
    public static void main(String[] args) {
        FieldChecker checker = new FieldChecker();
        // Example usage
        Fields fields = new Fields(); // Assuming Fields has a default constructor
        checker.setStoredFields(fields);
        System.out.println(checker.containsAllFields(fields)); // Should print true
    }
}
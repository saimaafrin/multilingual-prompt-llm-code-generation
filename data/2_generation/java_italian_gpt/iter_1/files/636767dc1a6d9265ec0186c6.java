public class FieldChecker {

    private Fields storedFields;

    /**
     * Restituisce true quando i campi di input sono già stati memorizzati nelle proprietà.
     */
    private boolean containsAllFields(Fields fields) {
        if (storedFields == null || fields == null) {
            return false;
        }
        
        // Assuming Fields has a method to get all field values
        return storedFields.equals(fields);
    }

    // Method to set stored fields for testing purposes
    public void setStoredFields(Fields fields) {
        this.storedFields = fields;
    }
    
    // Assuming a Fields class exists
    public static class Fields {
        // Fields implementation goes here
        // Override equals method to compare fields
    }
}
public class FieldChecker {

    private Fields storedFields;

    /**
     * Devuelve verdadero cuando los campos de entrada ya han sido almacenados en las propiedades.
     */
    private boolean containsAllFields(Fields fields) {
        if (fields == null || storedFields == null) {
            return false;
        }
        
        // Assuming Fields has a method to get all field names
        for (String fieldName : fields.getFieldNames()) {
            if (!storedFields.containsField(fieldName)) {
                return false;
            }
        }
        return true;
    }

    // Assuming a Fields class exists with the necessary methods
    public static class Fields {
        private Set<String> fieldNames;

        public Fields(Set<String> fieldNames) {
            this.fieldNames = fieldNames;
        }

        public Set<String> getFieldNames() {
            return fieldNames;
        }

        public boolean containsField(String fieldName) {
            return fieldNames.contains(fieldName);
        }
    }
}
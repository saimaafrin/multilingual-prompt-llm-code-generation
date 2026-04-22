import java.util.Objects;

public class FieldChecker {

    private Fields storedFields;

    public FieldChecker(Fields storedFields) {
        this.storedFields = storedFields;
    }

    /**
     * Restituisce true quando i campi di input sono già stati memorizzati nelle proprietà.
     */
    private boolean containsAllFields(Fields fields) {
        if (fields == null || storedFields == null) {
            return false;
        }
        return Objects.equals(fields.getField1(), storedFields.getField1()) &&
               Objects.equals(fields.getField2(), storedFields.getField2()) &&
               Objects.equals(fields.getField3(), storedFields.getField3());
    }

    // Assuming Fields class has getters for field1, field2, and field3
    public static class Fields {
        private String field1;
        private String field2;
        private String field3;

        public Fields(String field1, String field2, String field3) {
            this.field1 = field1;
            this.field2 = field2;
            this.field3 = field3;
        }

        public String getField1() {
            return field1;
        }

        public String getField2() {
            return field2;
        }

        public String getField3() {
            return field3;
        }
    }
}
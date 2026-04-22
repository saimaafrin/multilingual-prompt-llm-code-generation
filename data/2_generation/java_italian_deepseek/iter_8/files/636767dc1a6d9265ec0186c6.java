import java.util.Objects;

public class FieldChecker {

    private Fields storedFields;

    public FieldChecker(Fields storedFields) {
        this.storedFields = storedFields;
    }

    private boolean containsAllFields(Fields fields) {
        if (fields == null || storedFields == null) {
            return false;
        }
        return Objects.equals(fields.getField1(), storedFields.getField1()) &&
               Objects.equals(fields.getField2(), storedFields.getField2()) &&
               Objects.equals(fields.getField3(), storedFields.getField3());
    }

    public static void main(String[] args) {
        Fields storedFields = new Fields("value1", "value2", "value3");
        Fields inputFields = new Fields("value1", "value2", "value3");

        FieldChecker checker = new FieldChecker(storedFields);
        System.out.println(checker.containsAllFields(inputFields)); // Output: true
    }
}

class Fields {
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
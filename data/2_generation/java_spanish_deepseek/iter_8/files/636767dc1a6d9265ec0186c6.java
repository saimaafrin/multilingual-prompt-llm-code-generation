import java.util.Set;
import java.util.HashSet;

public class Fields {
    private Set<String> storedFields;

    public Fields() {
        this.storedFields = new HashSet<>();
    }

    public void addField(String field) {
        storedFields.add(field);
    }

    public boolean containsAllFields(Fields fields) {
        for (String field : fields.storedFields) {
            if (!this.storedFields.contains(field)) {
                return false;
            }
        }
        return true;
    }
}
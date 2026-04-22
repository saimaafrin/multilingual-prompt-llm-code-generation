import java.util.Set;

public class FieldChecker {
    private Set<String> storedFields;

    public FieldChecker(Set<String> storedFields) {
        this.storedFields = storedFields;
    }

    /**
     * 当输入字段已经存储在属性中时返回真。
     */
    private boolean containsAllFields(Fields fields) {
        for (String field : fields) {
            if (!storedFields.contains(field)) {
                return false;
            }
        }
        return true;
    }
}
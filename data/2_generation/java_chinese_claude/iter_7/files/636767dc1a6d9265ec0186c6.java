import org.apache.lucene.index.Fields;

public class FieldsChecker {
    private Set<String> storedFields;

    public FieldsChecker() {
        this.storedFields = new HashSet<>();
    }

    /**
     * 当输入字段已经存储在属性中时返回真。
     */
    private boolean containsAllFields(Fields fields) {
        if (fields == null) {
            return false;
        }

        try {
            Iterator<String> fieldIterator = fields.iterator();
            while (fieldIterator.hasNext()) {
                String field = fieldIterator.next();
                if (!storedFields.contains(field)) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
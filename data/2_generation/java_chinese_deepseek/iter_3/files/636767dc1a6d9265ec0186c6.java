import java.util.Set;

public class Example {
    private Set<String> storedFields;

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

    // Assuming Fields is a class that implements Iterable<String>
    private static class Fields implements Iterable<String> {
        private Set<String> fields;

        public Fields(Set<String> fields) {
            this.fields = fields;
        }

        @Override
        public Iterator<String> iterator() {
            return fields.iterator();
        }
    }
}
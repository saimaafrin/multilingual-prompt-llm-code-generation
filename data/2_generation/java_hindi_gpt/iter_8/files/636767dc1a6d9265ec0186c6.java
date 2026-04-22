public class FieldChecker {

    private Fields properties;

    public FieldChecker(Fields properties) {
        this.properties = properties;
    }

    /** 
     * जब इनपुट फ़ील्ड पहले से ही प्रॉपर्टीज़ में संग्रहीत होते हैं, तो यह सत्य (true) लौटाता है।
     */
    private boolean containsAllFields(Fields fields) {
        for (String field : fields.getFieldNames()) {
            if (!properties.containsField(field)) {
                return false;
            }
        }
        return true;
    }
}

class Fields {
    private Set<String> fieldNames;

    public Fields(Set<String> fieldNames) {
        this.fieldNames = fieldNames;
    }

    public Set<String> getFieldNames() {
        return fieldNames;
    }

    public boolean containsField(String field) {
        return fieldNames.contains(field);
    }
}
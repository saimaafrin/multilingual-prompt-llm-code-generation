public class FieldChecker {

    private Fields properties;

    public FieldChecker(Fields properties) {
        this.properties = properties;
    }

    /** 
     * जब इनपुट फ़ील्ड पहले से ही प्रॉपर्टीज़ में संग्रहीत होते हैं, तो यह सत्य (true) लौटाता है।
     */
    private boolean containsAllFields(Fields fields) {
        for (Field field : fields.getAllFields()) {
            if (!properties.contains(field)) {
                return false;
            }
        }
        return true;
    }
}

class Fields {
    // Assuming Fields class has a method to get all fields and check if a field exists
    public Field[] getAllFields() {
        // Implementation here
        return new Field[0]; // Placeholder
    }

    public boolean contains(Field field) {
        // Implementation here
        return false; // Placeholder
    }
}

class Field {
    // Field class implementation
}
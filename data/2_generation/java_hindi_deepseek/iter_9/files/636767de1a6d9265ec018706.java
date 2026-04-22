import java.util.HashMap;
import java.util.Map;

public class Mappings {
    private Map<String, Object> fields;

    public Mappings() {
        this.fields = new HashMap<>();
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }
}

public class MappingDiff {

    /**
     * उन मैपिंग्स को लौटाता है जिनमें ऐसे फ़ील्ड हैं जो इनपुट मैपिंग्स में मौजूद नहीं हैं। इनपुट मैपिंग्स को वर्तमान इंडेक्स से इतिहास मैपिंग होना चाहिए। वर्तमान इंडेक्स अपडेट संघर्ष से बचने के लिए _source कॉन्फ़िगरेशन को न लौटाएँ।
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        Mappings result = new Mappings();
        Map<String, Object> currentFields = getCurrentMappings(tableName).getFields();
        Map<String, Object> inputFields = mappings.getFields();

        for (Map.Entry<String, Object> entry : currentFields.entrySet()) {
            String key = entry.getKey();
            if (!inputFields.containsKey(key)) {
                result.getFields().put(key, entry.getValue());
            }
        }

        return result;
    }

    // Dummy method to simulate getting current mappings for a table
    private Mappings getCurrentMappings(String tableName) {
        Mappings currentMappings = new Mappings();
        Map<String, Object> fields = new HashMap<>();
        fields.put("field1", "type1");
        fields.put("field2", "type2");
        fields.put("field3", "type3");
        currentMappings.setFields(fields);
        return currentMappings;
    }
}
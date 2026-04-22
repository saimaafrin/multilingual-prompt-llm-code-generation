import com.google.gson.JsonObject;
import java.util.List;

public class PropertiesConverter {

    /**
     * 将进程属性转换为源数据
     */
    private JsonObject convertProperties(List<KeyStringValuePair> properties) {
        JsonObject jsonObject = new JsonObject();
        
        if (properties == null || properties.isEmpty()) {
            return jsonObject;
        }

        for (KeyStringValuePair property : properties) {
            if (property.getKey() != null && property.getValue() != null) {
                jsonObject.addProperty(property.getKey(), property.getValue());
            }
        }

        return jsonObject;
    }

    // KeyStringValuePair class for reference
    private static class KeyStringValuePair {
        private String key;
        private String value;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}
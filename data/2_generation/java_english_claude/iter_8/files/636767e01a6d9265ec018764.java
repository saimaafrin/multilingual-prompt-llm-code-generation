import com.google.gson.JsonObject;
import java.util.List;

public class PropertyConverter {

    /**
     * Convert process properties to source data
     */
    private JsonObject convertProperties(List<KeyStringValuePair> properties) {
        JsonObject jsonObject = new JsonObject();
        
        if (properties != null) {
            for (KeyStringValuePair property : properties) {
                if (property.getKey() != null && property.getValue() != null) {
                    jsonObject.addProperty(property.getKey(), property.getValue());
                }
            }
        }
        
        return jsonObject;
    }

    // Helper class for key-value pairs
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
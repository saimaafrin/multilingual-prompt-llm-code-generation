import com.google.gson.JsonObject;
import java.util.List;

public class PropertyConverter {

    /** 
     * Convertir propiedades del proceso a datos de origen
     */
    private JsonObject convertProperties(List<KeyStringValuePair> properties) {
        JsonObject jsonObject = new JsonObject();
        
        for (KeyStringValuePair property : properties) {
            jsonObject.addProperty(property.getKey(), property.getValue());
        }
        
        return jsonObject;
    }
}

class KeyStringValuePair {
    private String key;
    private String value;

    public KeyStringValuePair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
import com.google.gson.JsonObject;
import java.util.List;

public class PropertyConverter {

    /**
     * Converte le proprietà del processo in dati sorgente
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
}

class KeyStringValuePair {
    private String key;
    private String value;
    
    public String getKey() {
        return key;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

public class ContentBuilder {

    /**
     * construir contenido, si tiene "ats" alguien establece el "ats"
     */
    private Map<String,Object> buildContent(JsonObject jsonObject) {
        Map<String, Object> content = new HashMap<>();
        
        if (jsonObject != null) {
            // Iterate through all entries in JsonObject
            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                String key = entry.getKey();
                JsonElement element = entry.getValue();
                
                // Handle "ats" field specially
                if ("ats".equals(key)) {
                    content.put(key, element.getAsString());
                }
                // Handle other fields based on their type
                else if (element.isJsonPrimitive()) {
                    JsonPrimitive primitive = element.getAsJsonPrimitive();
                    if (primitive.isString()) {
                        content.put(key, primitive.getAsString());
                    } else if (primitive.isNumber()) {
                        content.put(key, primitive.getAsNumber());
                    } else if (primitive.isBoolean()) {
                        content.put(key, primitive.getAsBoolean());
                    }
                } else if (element.isJsonObject()) {
                    content.put(key, buildContent(element.getAsJsonObject()));
                } else if (element.isJsonArray()) {
                    content.put(key, element.getAsJsonArray());
                } else if (element.isJsonNull()) {
                    content.put(key, null);
                }
            }
        }
        
        return content;
    }
}
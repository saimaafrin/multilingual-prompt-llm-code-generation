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
                if ("ats".equals(key) && !element.isJsonNull()) {
                    content.put("ats", element.getAsString());
                }
                // Add other non-null fields to content map
                else if (!element.isJsonNull()) {
                    if (element.isJsonPrimitive()) {
                        content.put(key, element.getAsString());
                    } else if (element.isJsonObject()) {
                        content.put(key, buildContent(element.getAsJsonObject()));
                    } else if (element.isJsonArray()) {
                        content.put(key, element.getAsJsonArray());
                    }
                }
            }
        }
        
        return content;
    }
}
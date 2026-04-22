import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> content = new HashMap<>();
    
    // Iterate over all the keys in the JsonObject
    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
        String key = entry.getKey();
        JsonElement value = entry.getValue();
        
        // Check if the key is "ats" and handle it accordingly
        if (key.equals("ats")) {
            // Assuming "ats" is a special key that needs to be set by someone
            // Here we just add it to the content map as is
            content.put(key, value.getAsString());
        } else {
            // For other keys, add them to the content map
            if (value.isJsonPrimitive()) {
                content.put(key, value.getAsString());
            } else if (value.isJsonObject()) {
                content.put(key, buildContent(value.getAsJsonObject()));
            } else if (value.isJsonArray()) {
                // Handle arrays if needed
                // For simplicity, we'll just add them as a list of strings
                content.put(key, value.getAsJsonArray().toString());
            }
        }
    }
    
    return content;
}
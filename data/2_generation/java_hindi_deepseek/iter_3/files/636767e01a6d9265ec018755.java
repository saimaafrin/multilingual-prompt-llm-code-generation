import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> content = new HashMap<>();
    
    // Check if the JsonObject contains the key "ats"
    if (jsonObject.has("ats")) {
        content.put("ats", jsonObject.get("ats").getAsString());
    }
    
    // Add other fields from the JsonObject to the content map
    for (Map.Entry<String, com.google.gson.JsonElement> entry : jsonObject.entrySet()) {
        String key = entry.getKey();
        if (!key.equals("ats")) { // Skip "ats" since it's already handled
            content.put(key, entry.getValue().getAsString());
        }
    }
    
    return content;
}
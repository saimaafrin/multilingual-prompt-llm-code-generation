import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> content = new HashMap<>();
    
    // Check if the JsonObject contains the key "ats"
    if (jsonObject.has("ats")) {
        // If "ats" is present, add it to the content map
        content.put("ats", jsonObject.get("ats").getAsString());
    }
    
    // Add other fields from the JsonObject to the content map
    for (Map.Entry<String, com.google.gson.JsonElement> entry : jsonObject.entrySet()) {
        if (!entry.getKey().equals("ats")) {
            content.put(entry.getKey(), entry.getValue().getAsString());
        }
    }
    
    return content;
}
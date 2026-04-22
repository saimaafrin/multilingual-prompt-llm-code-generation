import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> content = new HashMap<>();

    // Iterate through all the keys in the JsonObject
    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
        String key = entry.getKey();
        JsonElement value = entry.getValue();

        // Check if the key is "ats" and if it has been set
        if (key.equals("ats") && !value.isJsonNull()) {
            content.put(key, value.getAsString());
        } else {
            // Add other key-value pairs to the content map
            if (value.isJsonPrimitive()) {
                content.put(key, value.getAsString());
            } else if (value.isJsonObject()) {
                content.put(key, buildContent(value.getAsJsonObject()));
            } else if (value.isJsonArray()) {
                // Handle arrays if needed
                // For simplicity, we'll just add them as a list
                content.put(key, value.getAsJsonArray());
            }
        }
    }

    return content;
}
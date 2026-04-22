import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> content = new HashMap<>();

    // Iterate over all keys in the JsonObject
    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
        String key = entry.getKey();
        JsonElement value = entry.getValue();

        // Check if the key is "ats" and handle it accordingly
        if (key.equals("ats")) {
            // Assuming the value is a JsonObject or JsonArray, convert it to a Map or List
            if (value.isJsonObject()) {
                content.put(key, buildContent(value.getAsJsonObject()));
            } else if (value.isJsonArray()) {
                // Handle JsonArray if needed
                // For simplicity, we'll just add it as is
                content.put(key, value);
            } else {
                // Handle primitive types
                content.put(key, value.getAsString());
            }
        } else {
            // For other keys, add them directly to the content map
            if (value.isJsonObject()) {
                content.put(key, buildContent(value.getAsJsonObject()));
            } else if (value.isJsonArray()) {
                // Handle JsonArray if needed
                // For simplicity, we'll just add it as is
                content.put(key, value);
            } else {
                // Handle primitive types
                content.put(key, value.getAsString());
            }
        }
    }

    return content;
}
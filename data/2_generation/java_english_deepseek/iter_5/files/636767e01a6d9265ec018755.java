import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> contentMap = new HashMap<>();

    // Iterate over all entries in the JsonObject
    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
        String key = entry.getKey();
        JsonElement value = entry.getValue();

        // Check if the key is "ats" and handle it accordingly
        if (key.equals("ats")) {
            // Assuming "ats" is a special field that needs to be set by someone
            // Here we just add it to the map as is, but you can modify this logic as needed
            contentMap.put(key, value.getAsString());
        } else {
            // For other fields, add them to the map as is
            if (value.isJsonPrimitive()) {
                contentMap.put(key, value.getAsString());
            } else if (value.isJsonObject()) {
                contentMap.put(key, buildContent(value.getAsJsonObject()));
            } else if (value.isJsonArray()) {
                // Handle arrays if needed
                contentMap.put(key, value.getAsJsonArray());
            }
        }
    }

    return contentMap;
}
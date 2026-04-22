import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> contentMap = new HashMap<>();

    // Iterate through the JSON object and add each key-value pair to the map
    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
        String key = entry.getKey();
        JsonElement value = entry.getValue();

        // Check if the key is "ats" and handle it accordingly
        if (key.equals("ats")) {
            // Assuming "ats" is a special field that needs to be set
            contentMap.put(key, value.getAsString()); // or getAsInt(), getAsBoolean(), etc., depending on the expected type
        } else {
            // Handle other fields
            if (value.isJsonPrimitive()) {
                contentMap.put(key, value.getAsString()); // or getAsInt(), getAsBoolean(), etc.
            } else if (value.isJsonObject()) {
                contentMap.put(key, buildContent(value.getAsJsonObject())); // Recursively handle nested objects
            } else if (value.isJsonArray()) {
                // Handle arrays if needed
                // contentMap.put(key, handleArray(value.getAsJsonArray()));
            }
        }
    }

    return contentMap;
}
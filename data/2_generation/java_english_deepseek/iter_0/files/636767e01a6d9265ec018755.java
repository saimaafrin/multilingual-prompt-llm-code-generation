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
            // Assuming "ats" is a special field that needs to be set
            content.put(key, value.getAsString()); // or getAsInt(), getAsBoolean(), etc., depending on the expected type
        } else {
            // Handle other fields
            if (value.isJsonPrimitive()) {
                // Handle primitive types (String, Number, Boolean)
                content.put(key, value.getAsString());
            } else if (value.isJsonObject()) {
                // Recursively handle nested JsonObject
                content.put(key, buildContent(value.getAsJsonObject()));
            } else if (value.isJsonArray()) {
                // Handle JsonArray if needed
                // You can add logic to handle arrays here
            }
        }
    }

    return content;
}
import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> content = new HashMap<>();

    // Check if "ats" is present in the JsonObject
    if (jsonObject.has("ats")) {
        JsonElement atsElement = jsonObject.get("ats");
        if (atsElement.isJsonPrimitive()) {
            content.put("ats", atsElement.getAsString());
        } else if (atsElement.isJsonObject()) {
            content.put("ats", atsElement.getAsJsonObject());
        } else if (atsElement.isJsonArray()) {
            content.put("ats", atsElement.getAsJsonArray());
        }
    }

    // Add other fields from the JsonObject to the content map
    for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
        String key = entry.getKey();
        JsonElement value = entry.getValue();

        if (value.isJsonPrimitive()) {
            content.put(key, value.getAsString());
        } else if (value.isJsonObject()) {
            content.put(key, value.getAsJsonObject());
        } else if (value.isJsonArray()) {
            content.put(key, value.getAsJsonArray());
        }
    }

    return content;
}
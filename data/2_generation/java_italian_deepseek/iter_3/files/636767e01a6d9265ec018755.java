import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> content = new HashMap<>();

    // Check if the JsonObject contains the key "ATS"
    if (jsonObject.has("ATS")) {
        // If it contains "ATS", set the "ATS" value in the map
        content.put("ATS", jsonObject.get("ATS").getAsString());
    }

    // You can add more logic here to build the rest of the content if needed

    return content;
}
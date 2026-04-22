import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> content = new HashMap<>();

    // Check if the JsonObject contains the key "ats"
    if (jsonObject.has("ats")) {
        // If "ats" is present, set it in the content map
        content.put("ats", jsonObject.get("ats").getAsString());
    }

    // You can add more logic here to process other fields in the JsonObject if needed

    return content;
}
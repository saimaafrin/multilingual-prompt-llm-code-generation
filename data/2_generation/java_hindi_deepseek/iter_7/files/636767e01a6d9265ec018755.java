import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;

public class ContentBuilder {

    /**
     * सामग्री बनाएं, यदि इसमें ats है तो किसी ने ats सेट किया है
     */
    private Map<String, Object> buildContent(JsonObject jsonObject) {
        Map<String, Object> content = new HashMap<>();

        // Check if "ats" key exists in the JsonObject
        if (jsonObject.has("ats")) {
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
}
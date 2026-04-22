import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentBuilder {

    /**
     * build content,if it has ats someone set the ats
     */
    private Map<String,Object> buildContent(JsonObject jsonObject) {
        Map<String,Object> content = new HashMap<>();
        
        if (jsonObject == null) {
            return content;
        }

        // Add text content if exists
        if (jsonObject.has("text") && !jsonObject.get("text").isJsonNull()) {
            content.put("text", jsonObject.get("text").getAsString());
        }

        // Handle @ mentions if they exist
        if (jsonObject.has("ats") && !jsonObject.get("ats").isJsonNull()) {
            JsonArray atsArray = jsonObject.getAsJsonArray("ats");
            if (atsArray != null && atsArray.size() > 0) {
                List<String> atsList = new ArrayList<>();
                for (JsonElement element : atsArray) {
                    if (!element.isJsonNull()) {
                        atsList.add(element.getAsString());
                    }
                }
                if (!atsList.isEmpty()) {
                    content.put("ats", atsList);
                }
            }
        }

        // Add any other content fields that might exist
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            if (!key.equals("text") && !key.equals("ats") && !entry.getValue().isJsonNull()) {
                content.put(key, entry.getValue().getAsString());
            }
        }

        return content;
    }
}
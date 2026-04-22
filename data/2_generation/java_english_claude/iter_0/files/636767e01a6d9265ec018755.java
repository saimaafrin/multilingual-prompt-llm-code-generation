import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

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
                for (int i = 0; i < atsArray.size(); i++) {
                    if (!atsArray.get(i).isJsonNull()) {
                        atsList.add(atsArray.get(i).getAsString());
                    }
                }
                if (!atsList.isEmpty()) {
                    content.put("ats", atsList);
                }
            }
        }

        return content;
    }
}
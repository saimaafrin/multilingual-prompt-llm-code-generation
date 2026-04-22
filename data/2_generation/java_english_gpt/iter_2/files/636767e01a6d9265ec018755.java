import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> contentMap = new HashMap<>();

    if (jsonObject.has("ats")) {
        contentMap.put("ats", jsonObject.get("ats").getAsString());
    }

    // Add other content building logic here if needed

    return contentMap;
}
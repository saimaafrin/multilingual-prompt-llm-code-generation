import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> content = new HashMap<>();
    
    if (jsonObject.has("ats")) {
        content.put("ats", jsonObject.get("ats").getAsString());
    } else {
        content.put("message", "No ats set");
    }
    
    return content;
}
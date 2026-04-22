import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> contentMap = new HashMap<>();
    
    // Assuming the JsonObject has a method to get the content as a string
    String content = jsonObject.get("content").getAsString();
    
    // Check if the content contains '@' symbol
    if (content.contains("@")) {
        // Extract the mentioned user(s)
        String[] mentions = content.split("@");
        for (int i = 1; i < mentions.length; i++) {
            String mention = mentions[i].split(" ")[0]; // Get the username before the next space
            contentMap.put("mention" + i, mention);
        }
    }
    
    contentMap.put("content", content);
    return contentMap;
}
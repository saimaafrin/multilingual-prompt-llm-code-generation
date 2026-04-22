import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> contentMap = new HashMap<>();
    
    // Assuming the JsonObject contains a field "content" which holds the main content
    String content = jsonObject.get("content").getAsString();
    contentMap.put("content", content);
    
    // Check if the content contains '@' to identify mentions
    if (content.contains("@")) {
        // Extract the mentioned user (simplified logic)
        String[] parts = content.split("@");
        if (parts.length > 1) {
            String mentionedUser = parts[1].split("\\s+")[0]; // Get the first word after '@'
            contentMap.put("mentionedUser", mentionedUser);
        }
    }
    
    return contentMap;
}
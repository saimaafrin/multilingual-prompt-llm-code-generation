import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> contentMap = new HashMap<>();
    
    // Assuming the JsonObject contains a field "text" which holds the content
    String text = jsonObject.get("text").getAsString();
    
    // Check if the text contains '@' to identify mentions
    if (text.contains("@")) {
        // Extract the mentioned user (assuming the format is "@username")
        String[] parts = text.split("@");
        if (parts.length > 1) {
            String mentionedUser = parts[1].split("\\s+")[0]; // Get the first word after '@'
            contentMap.put("mentionedUser", mentionedUser);
        }
    }
    
    // Add the text to the content map
    contentMap.put("text", text);
    
    return contentMap;
}
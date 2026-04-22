import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> contentMap = new HashMap<>();
    
    // Assuming the JsonObject contains a field "content" which is a string
    if (jsonObject.has("content")) {
        String content = jsonObject.get("content").getAsString();
        contentMap.put("content", content);
        
        // Check if the content contains '@' mentions
        if (content.contains("@")) {
            // Extract mentions and add to the map
            String[] words = content.split(" ");
            for (String word : words) {
                if (word.startsWith("@")) {
                    String mention = word.substring(1); // Remove the '@' symbol
                    contentMap.put("mention", mention);
                    break; // Assuming only one mention is processed
                }
            }
        }
    }
    
    return contentMap;
}
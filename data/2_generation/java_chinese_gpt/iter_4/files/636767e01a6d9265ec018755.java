import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;

public class ContentBuilder {

    /** 
     * 构建内容，如果包含 @ 某人，则设置 @ 信息。
     */
    private Map<String, Object> buildContent(JsonObject jsonObject) {
        Map<String, Object> contentMap = new HashMap<>();
        
        // Assuming the JsonObject has a field "content" that we need to check for mentions
        String content = jsonObject.get("content").getAsString();
        
        // Check for mentions in the content
        if (content.contains("@")) {
            // Extract the mentioned user(s)
            String[] parts = content.split(" ");
            for (String part : parts) {
                if (part.startsWith("@")) {
                    String mentionedUser = part.substring(1); // Remove the '@' symbol
                    contentMap.put("mentionedUser", mentionedUser);
                }
            }
        }
        
        contentMap.put("content", content);
        return contentMap;
    }
}
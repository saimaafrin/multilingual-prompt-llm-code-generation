import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> contentMap = new HashMap<>();
    
    // Assuming the JsonObject contains a "text" field with the content
    String text = jsonObject.get("text").getAsString();
    
    // Regular expression to match @mentions
    Pattern mentionPattern = Pattern.compile("@(\\w+)");
    Matcher matcher = mentionPattern.matcher(text);
    
    // Find all mentions and add them to the map
    while (matcher.find()) {
        String mention = matcher.group(1);
        contentMap.put("@" + mention, true);
    }
    
    // Add the original text to the map
    contentMap.put("text", text);
    
    return contentMap;
}
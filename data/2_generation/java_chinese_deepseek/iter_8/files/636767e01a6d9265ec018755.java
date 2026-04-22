import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentBuilder {

    /**
     * 构建内容，如果包含 @ 某人，则设置 @ 信息。
     */
    private Map<String, Object> buildContent(JsonObject jsonObject) {
        Map<String, Object> contentMap = new HashMap<>();
        
        // 假设jsonObject中有一个字段 "content" 存储了内容
        String content = jsonObject.get("content").getAsString();
        
        // 使用正则表达式匹配 @ 某人
        Pattern pattern = Pattern.compile("@(\\w+)");
        Matcher matcher = pattern.matcher(content);
        
        // 如果匹配到 @ 某人，则设置 @ 信息
        if (matcher.find()) {
            String mentionedUser = matcher.group(1);
            contentMap.put("mentionedUser", mentionedUser);
        }
        
        // 将内容放入map中
        contentMap.put("content", content);
        
        return contentMap;
    }
}
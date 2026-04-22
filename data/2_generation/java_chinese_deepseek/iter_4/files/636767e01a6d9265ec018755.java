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
        String content = jsonObject.get("content").getAsString();

        // 检查内容中是否包含 @ 某人
        Pattern pattern = Pattern.compile("@(\\w+)");
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            String mentionedUser = matcher.group(1);
            contentMap.put("mentionedUser", mentionedUser);
        }

        // 将内容放入Map
        contentMap.put("content", content);

        return contentMap;
    }
}